package com.gmail.mosoft521.se.book.ui;

import com.gmail.mosoft521.se.book.entity.Publisher;
import com.gmail.mosoft521.se.book.service.PublisherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Vector;

/**
 * 出版社录入的JPanel对象
 */
public class PublisherPanel extends CommonPanel {
    private static Logger LOGGER = LoggerFactory.getLogger(PublisherPanel.class);

    private PublisherService publisherService;

    //title
    private String title = "长江图书公司记账信息管理系统-出版社录入";

    //清空按钮
    JButton clearButton;
    //保存按钮
    JButton saveButton;
    //id(隐藏)
    JTextField concernId;
    //出版社名称
    JTextField concernName;
    //联系人
    JTextField pubLinkMan;
    //联系电话
    JTextField pubTel;
    //简介
    JTextArea pubIntro;
    //查询按钮
    JButton queryButton;
    //根据名称查询的输入框
    JTextField queryName;
    private Vector columns;

    public PublisherPanel(ApplicationContext context) {
        this.publisherService = context.getBean("publisherService", PublisherService.class);
        //初始化列集合
        initColumns();
        //设置列表数据
        setViewDatas();
        //设置列表
        DefaultTableModel model = new DefaultTableModel(null, this.columns);
        JTable table = new CommonJTable(model);
        setJTable(table);
        JScrollPane upPane = new JScrollPane(table);
        upPane.setPreferredSize(new Dimension(1000, 350));
        //设置添加, 修改的界面
        JPanel downPane = new JPanel();
        downPane.setLayout(new BoxLayout(downPane, BoxLayout.Y_AXIS));
        /*******************************************************/
        Box downBox1 = new Box(BoxLayout.X_AXIS);
        //新建JTextField保存id
        concernId = new JTextField();
        //设置为不可见
        concernId.setVisible(false);
        downBox1.add(concernId);
        //列表下面的box
        downBox1.add(new JLabel("出版社名称："));
        downBox1.add(Box.createHorizontalStrut(10));
        concernName = new JTextField(10);
        downBox1.add(concernName);
        downBox1.add(Box.createHorizontalStrut(400));
        /*******************************************************/
        Box downBox2 = new Box(BoxLayout.X_AXIS);
        downBox2.add(new JLabel("联  系  人："));
        downBox2.add(Box.createHorizontalStrut(10));
        pubLinkMan = new JTextField(10);
        downBox2.add(pubLinkMan);
        downBox2.add(Box.createHorizontalStrut(50));
        downBox2.add(new JLabel("联系电话："));
        downBox2.add(Box.createHorizontalStrut(10));
        pubTel = new JTextField(10);
        downBox2.add(pubTel);
        /*******************************************************/
        Box downBox3 = new Box(BoxLayout.X_AXIS);
        downBox3.add(new JLabel("简介："));
        downBox3.add(Box.createHorizontalStrut(35));
        pubIntro = new JTextArea("", 5, 5);
        JScrollPane introScrollPane = new JScrollPane(pubIntro);
        //设置换行
        pubIntro.setLineWrap(true);
        downBox3.add(introScrollPane);
        /*******************************************************/
        Box downBox4 = new Box(BoxLayout.X_AXIS);
        saveButton = new JButton("保存");
        downBox4.add(saveButton);
        downBox4.add(Box.createHorizontalStrut(30));
        clearButton = new JButton("清空");
        downBox4.add(clearButton);
        downBox4.add(Box.createHorizontalStrut(30));
        /*******************************************************/
        downPane.add(getSplitBox());
        downPane.add(downBox1);
        downPane.add(getSplitBox());
        downPane.add(downBox2);
        downPane.add(getSplitBox());
        downPane.add(downBox3);
        downPane.add(getSplitBox());
        downPane.add(downBox4);
        /*******************查询******************/
        JPanel queryPanel = new JPanel();
        Box queryBox = new Box(BoxLayout.X_AXIS);
        queryBox.add(new JLabel("名称："));
        queryBox.add(Box.createHorizontalStrut(30));
        queryName = new JTextField(20);
        queryBox.add(queryName);
        queryBox.add(Box.createHorizontalStrut(30));
        queryButton = new JButton("查询");
        queryBox.add(queryButton);
        queryPanel.add(queryBox);
        this.add(queryPanel);
        //列表为添加界面
        JSplitPane split = new JSplitPane(JSplitPane.VERTICAL_SPLIT, upPane, downPane);
        split.setDividerSize(5);
        this.add(split);
        //初始化监听器
        initListeners();
    }

    //初始化列
    private void initColumns() {
        this.columns = new Vector();
        this.columns.add("id");
        this.columns.add("出版社名称");
        this.columns.add("联系人");
        this.columns.add("联系电话");
        this.columns.add("简介");
    }

    //初始化监听器
    private void initListeners() {
        //表格选择监听器
        getJTable().getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                //当选择行时鼠标释放时才执行
                if (!event.getValueIsAdjusting()) {
                    //如果没有选中任何一行, 则返回
                    if (getJTable().getSelectedRowCount() != 1) return;
                    //调用父类的方法获得选择行的id
                    Integer id = getSelectId(getJTable());
                    view(id);
                }
            }
        });
        //清空按钮监听器
        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                clear();
            }
        });
        //保存按钮监听器
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                save();
            }
        });
        //查询按钮监听器
        queryButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                query();
            }
        });
        this.queryButton.registerKeyboardAction(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LOGGER.info("query");
                query();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), JComponent.WHEN_IN_FOCUSED_WINDOW);
    }

    //按名字模糊查询
    private void query() {
        String name = this.queryName.getText();
        List<Publisher> concerns = publisherService.query(name);
        //转换数据格式
        Vector<Vector> datas = changeDatas(concerns);
        //设置数据
        setDatas(datas);
        //刷新列表
        refreshTable();
    }

    //查看一个出版社
    private void view(Integer id) {
        Publisher c = publisherService.find(id);
        //设置ID的JTextFiled（隐藏）
        this.concernId.setText(c.getId().toString());
        //设置出版社名称的文本框
        this.concernName.setText(c.getPubName());
        //设置联系人的文本框
        this.pubLinkMan.setText(c.getPubLinkMan());
        //设置联系电话的文本框
        this.pubTel.setText(c.getPubTel());
        //设置简介的文本域
        this.pubIntro.setText(c.getPubIntro());
    }

    //保存方法
    private void save() {
        if (this.concernName.getText().trim().equals("")) {
            //调用父类的方法，弹出错误提示
            showWarn("请输入出版社名称");
            return;
        }
        //如果id为空, 则为新增, 不为空则为修改操作
        if (this.concernId.getText().equals("")) add();
        else update();
    }

    //新增方法
    private void add() {
        //获得界面中的值并封装成对象
        Publisher c = getConcern();
        publisherService.add(c);
        //重新读取数据
        setViewDatas();
        //刷新表单
        clear();
    }

    //修改方法
    private void update() {
        //取得当前修改记录的ID
        String id = this.concernId.getText();
        //根据界面数据获得Concern对象
        Publisher c = getConcern();
        c.setId(Integer.valueOf(id));
        publisherService.update(c);
        //重新读取数据
        setViewDatas();
        //刷新列表
        refreshTable();
    }

    //从表单中获取数据并封装成Concern对象, 没有id
    private Publisher getConcern() {
        String concernName = this.concernName.getText();
        String pubTel = this.pubTel.getText();
        String pubLinkMan = this.pubLinkMan.getText();
        String pubIntro = this.pubIntro.getText();
        Publisher publisher = new Publisher();
        publisher.setPubName(concernName);
        publisher.setPubTel(pubTel);
        publisher.setPubLinkMan(pubLinkMan);
        publisher.setPubIntro(pubIntro);
        return publisher;
    }

    //清空表单并刷新列表
    public void clear() {
        //刷新列表
        refreshTable();
        //清空表单中的各个文本框（域）的值
        this.concernId.setText("");
        this.concernName.setText("");
        this.pubLinkMan.setText("");
        this.pubTel.setText("");
        this.pubIntro.setText("");
    }

    @Override
    public Vector<String> getColumns() {
        return this.columns;
    }

    /*
     * 设置表格样式(non-Javadoc)
     * @see CommonPanel#setTableFace()
     */
    public void setTableFace() {
        //隐藏id列
        getJTable().getColumn("id").setMinWidth(-1);
        getJTable().getColumn("id").setMaxWidth(-1);
        getJTable().getColumn("简介").setMinWidth(400);
        getJTable().setRowHeight(30);
    }

    /**
     * 将数据转换成视图表格的格式
     *
     * @param datas
     * @return
     */
    private Vector<Vector> changeDatas(List<Publisher> datas) {
        Vector<Vector> view = new Vector<Vector>();
        for (Publisher c : datas) {
            Vector v = new Vector();
            v.add(c.getId());
            v.add(c.getPubName());
            v.add(c.getPubLinkMan());
            v.add(c.getPubTel());
            v.add(c.getPubIntro());
            view.add(v);
        }
        return view;
    }

    /*
     * 实现父类方法, 查询数据库并返回对应的数据格式, 调用父类的setDatas方法设置数据集合
     */
    public void setViewDatas() {
        //使用业务接口得到数据
        List<Publisher> concerns = publisherService.getAll();
        //将数据转换成显示格式
        Vector<Vector> datas = changeDatas(concerns);
        //调用父类的setDatas方法
        setDatas(datas);
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }
}
