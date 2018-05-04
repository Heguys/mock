package com.hxminco.mock.ext.filter;


import com.hxminco.mock.comm.entry.MockManager;
import com.hxminco.mock.comm.entry.MockStudent;
import com.hxminco.mock.comm.utils.MockConstants;

public class PermissionChecker {
	private MockManager mockManager;
	private MockStudent mockStudent;

	/**
	 * 是学生
	 * 
	 * @return
	 */
	public boolean isStudent() {
		return mockStudent != null;
	}
	/**
	 * 是管理员
	 *
	 * @return
	 */
	public boolean isManager() {
		return mockManager != null;
	}




	/**
	 * 是否能管理知识点
	 *
	 * @return
	 */
	public boolean isKnowledgeManager() {
		return isManager();
	}

	/**
	 * 是否能管理试卷
	 *
	 * @return
	 */
	public boolean isPaperManager() {
		return isManager();
	}

	/**
	 * 是否能管理学生
	 *
	 * @return
	 */
	public boolean isStudentManager() {
		return isManager();
	}

	/**
	 * 是否能管理课程
	 *
	 * @return
	 */
	public boolean isCourseManager() {
		return isManager();
	}

	/**
	 * 是超级管理员
	 *
	 * @return
	 */
	public boolean isSuperAdmin() {
		return isManager() && mockManager.getAccount().equals(MockConstants.SUPER_ACCOUNT);
	}

	public MockManager getMockManager() {
		return mockManager;
	}

	public void setMockManager(MockManager mockManager) {
		this.mockManager = mockManager;
	}

	public MockStudent getMockStudent() {
		return mockStudent;
	}

	public void setMockStudent(MockStudent mockStudent) {
		this.mockStudent = mockStudent;
	}

}
