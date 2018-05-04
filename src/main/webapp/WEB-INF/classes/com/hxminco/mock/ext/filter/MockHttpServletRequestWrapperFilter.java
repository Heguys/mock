package com.hxminco.mock.ext.filter;

import com.hxminco.mock.comm.entry.MockManager;
import com.hxminco.mock.comm.entry.MockStudent;
import com.hxminco.mock.comm.utils.MockCommonUtil;
import com.hxminco.mock.comm.utils.MockConstants;
import com.hxminco.mock.comm.utils.SpringContextUtil;
import com.hxminco.mock.ioc.s.IMockManagerService;
import com.hxminco.mock.ioc.s.IMockStudentService;
import net.bnusei.model.UserBaseInfo;
import net.bnusei.sso.client.util.HttpServletRequestWrapperFilter;
import net.bnusei.util.HttpUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class MockHttpServletRequestWrapperFilter extends HttpServletRequestWrapperFilter {
	private static final Logger logger = LoggerFactory.getLogger(MockHttpServletRequestWrapperFilter.class);

	private static boolean putMockStudentInSession = true;
	IMockManagerService mockManagerService = SpringContextUtil.getBean("mockManagerService");
	IMockStudentService mockStudentService = SpringContextUtil.getBean("mockStudentService");

	@Override
	protected void updateLocalManagerInfo(HttpServletRequest request, UserBaseInfo userBaseInfo) {
		HttpSession session = HttpUtil.getHttpSession(request);
		MockManager mockManager = session == null ? null
				: (MockManager) session.getAttribute(MockManager.class.getName());
		if (userBaseInfo != null
				&& (mockManager == null || !mockManager.getAccount().equals(userBaseInfo.getAccount()))) {
			try {
				mockManager = mockManagerService.updateMockManager((String) null, userBaseInfo.getAccount(),
						userBaseInfo.getName(), userBaseInfo.getInstitutionUid(), userBaseInfo.isAdministrator());
			} catch (Exception e) {
				logger.error("updateLocalManagerInfo", e);
			}
		}
		if (mockManager != null) {
			request.setAttribute(MockManager.class.getName(), mockManager);
			if (session != null) {
				session.setAttribute(MockManager.class.getName(), mockManager);
				session.setAttribute(MockConstants.USER_BASE_SESSION_KEY, userBaseInfo);
			}
		}
	}

	@Override
	protected void updateLocalStudentInfo(HttpServletRequest request, UserBaseInfo userBaseInfo) {
		HttpSession session = HttpUtil.getHttpSession(request);
		MockStudent mockStudent = session == null || !putMockStudentInSession ? null
				: (MockStudent) session.getAttribute(MockStudent.class.getName());
		if (userBaseInfo != null
				&& (mockStudent == null || !mockStudent.getAccount().equals(userBaseInfo.getAccount()))) {
			try {
				mockStudent = mockStudentService.updateMockStudent((String) null, userBaseInfo.getAccount(),
						userBaseInfo.getName());
			} catch (Exception e) {
				logger.error("updateLocalStudentInfo", e);
			}
		}
		if (mockStudent != null) {
			request.setAttribute(MockStudent.class.getName(), mockStudent);
			if (session != null && putMockStudentInSession) {
				session.setAttribute(MockStudent.class.getName(), mockStudent);
				session.setAttribute(MockConstants.USER_BASE_SESSION_KEY, userBaseInfo);
			}
		}
	}

	@Override
	protected void extraInit(HttpServletRequest request) {
		MockManager mockManager = MockCommonUtil.getMockManager(request);
		MockStudent mockStudent = MockCommonUtil.getMockStudent(request);
		PermissionChecker permissionChecker = null;

		permissionChecker = new PermissionChecker();
		if (mockManager != null) {
			permissionChecker.setMockManager(mockManager);
		}
		if (mockStudent != null) {
			permissionChecker.setMockStudent(mockStudent);
		}
		request.setAttribute(PermissionChecker.class.getName(), permissionChecker);
	}
}
