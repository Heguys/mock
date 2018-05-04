package com.hxminco.mock.comm.utils;
import com.hxminco.mock.comm.entry.MockManager;
import com.hxminco.mock.comm.entry.MockStudent;

import javax.servlet.http.HttpServletRequest;

import com.hxminco.mock.ext.filter.PermissionChecker;
import net.bnusei.util.HttpUtil;
import net.bnusei.util.StringPool;
public class MockCommonUtil {


	/**
	 * 读取当前登录的学生
	 * 
	 * @return
	 */
	public static MockStudent getMockStudent() {
		HttpServletRequest request = HttpUtil.getHttpServletRequest();
		return getMockStudent(request);
	}

	/**
	 * 读取当前登录的学生
	 * 
	 * @param request
	 * @return
	 */
	public static MockStudent getMockStudent(HttpServletRequest request) {
		MockStudent mockStudent = null;
		if (request != null) {
			mockStudent = (MockStudent) request.getAttribute(MockStudent.class.getName());
		}
		return mockStudent;
	}

	/**
	 * 读取当前登录的管理员
	 *
	 * @param request
	 * @return
	 */
	public static MockManager getMockManager(HttpServletRequest request) {
		MockManager mockManager = null;
		if (request != null) {
			mockManager = (MockManager) request.getAttribute(MockManager.class.getName());
		}
		return mockManager;
	}

	/**
	 * 获取权限判断对象
	 * 
	 * @param request
	 * @return
	 */
	public static PermissionChecker getPermissionChecker(HttpServletRequest request) {
		PermissionChecker permissionChecker = null;
		if (request != null) {
			permissionChecker = (PermissionChecker) request.getAttribute(PermissionChecker.class.getName());
		}
		return permissionChecker;
	}

	/**
	 * 
	 * 当前登录学生显示名称
	 * 
	 * @param request
	 * @return
	 */
	public static String getMockStudentShowName(HttpServletRequest request) {
		String name = null;
		if (request != null) {
			MockStudent mockStudent = getMockStudent(request);
			name = mockStudent == null ? request.getRemoteUser() : mockStudent.getName();
		}
		if (name == null) {
			name = StringPool.BLANK;
		}
		return name;
	}
}
