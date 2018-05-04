package com.hxminco.mock.comm.utils;

import com.hxminco.mock.comm.entry.MockStudent;
import net.bnusei.model.UserBaseInfo;
import net.bnusei.util.PropsUtil;

public interface MockConstants {
	/**
	 * 启动时间
	 */
	final long t = System.currentTimeMillis();

	/**
	 * 超级用户账户
	 */
	String SUPER_ACCOUNT = "admin";

	/**
	 * 富文本
	 */
	String CONTENT_TYPE_HTML = "html";
	/**
	 * 附件
	 */
	String CONTENT_TYPE_FILE = "file";
	/**
	 * 内容类型
	 */
	String[] CONTENT_TYPES = new String[] { CONTENT_TYPE_HTML, CONTENT_TYPE_FILE };

	/**
	 * 取证类型 : 初领
	 */
	int ASSESSMENT_TYPE_FIRST = 1;
	/**
	 * 取证类型 : 复审
	 */
	int ASSESSMENT_TYPE_AGAIN = 2;
	/**
	 * 取证类型 : 换证
	 */
	int ASSESSMENT_TYPE_CHANGE = 3;

	/**
	 * 取证类型
	 */
	int[] ASSESSMENT_TYPES = new int[] { ASSESSMENT_TYPE_FIRST, ASSESSMENT_TYPE_AGAIN, ASSESSMENT_TYPE_CHANGE };

	/**
	 * 题型：单选题
	 */
	int QUESTION_TYPE_CHOICE_SINGLE = 1;

	/**
	 * 题型：多选题
	 */
	int QUESTION_TYPE_CHOICE_MULTI = 2;

	/**
	 * 题型：判断题
	 */
	int QUESTION_TYPE_JUDGE = 3;

	/**
	 * 试题来源：总局
	 */
	int QUESTION_SOURCE_CENTRAL = 0;

	/**
	 * 试题来源：地方
	 */
	int QUESTION_SOURCE_LOCAL = 1;
	/**
	 * 考试状态：未开始
	 */
	int EXAM_STATUS_TODO = 1;

	/**
	 * 考试状态：正在考试
	 */
	int EXAM_STATUS_DOING = 2;

	/**
	 * 考试状态：已完成
	 */
	int EXAM_STATUS_COMPLETED = 3;

	/**
	 * 学生首页的分页大小
	 */
	int PAGE_SIZE_HOME = PropsUtil.getInt("page.size.home");

	/**
	 * 缺省分页大小
	 */
	int PAGE_SIZE_DEFAULT = PropsUtil.getInt("page.size.default");

	/**
	 * 自动审核购买模考
	 */
	boolean STUDENT_PURCHASE_VERIFY_AUTO = PropsUtil.getBoolean("student.purchase.verify.auto");

	/**
	 * 学生导航显示考核对象下拉菜单
	 */
	boolean STUDENT_NAVBAR_PAPER_MAJOR_DROPDOWN_ENABLE = PropsUtil
			.getBoolean("student.navbar.paper.major.dropdown.enable");

	/**
	 * 每个考核对象最多的课程数，0表示不限制
	 */
	int COURSE_MAX_COUNT_PER_MAJOR_AND_ASSERT = PropsUtil.getInt("course.max.counter.per.major.and.assert");

	/**
	 * 缺省分页参数
	 */
	String PAGE_NAME_DEFAULT = "page";

	/**
	 * 管理员界面自动跳转
	 */
	String URI_MANAGER_AUTO_REDIRECT_TO = PropsUtil.getString("uri.manager.auto.redirect.to");

	/**
	 * 不限模考
	 */
	boolean STUDENT_MOCK_UNLIMITED = PropsUtil.getBoolean("student.mock.unlimited");

	/**
	 * 基础系统的部署地址
	 */
	final String SERVER_BASIC_SYSTEM_URL = PropsUtil.getString("server.base.url");

	/**
	 * 基础系统的部署地址
	 */
	final String SERVER_EXAM_SYSTEM_URL = PropsUtil.getString("server.exam.url");

	final  String STUDENT_SESSION_KEY = MockStudent.class.getName();

	final String USER_BASE_SESSION_KEY = UserBaseInfo.class.getName();

}
