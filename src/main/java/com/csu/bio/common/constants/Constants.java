package com.csu.bio.common.constants;

/**
 * 全局变量
 * 
 */

public class Constants {

	public static final String CONTEXT_VARIABLE_PREFIX = "imagefile";

	public static final String DFS_PCT_URL_PREFIX = "/dfs/pct?id=";
	public static final String DFS_IMG_URL_PREFIX = "/dfs/img?id=";

	public static final int ADMIN_GROUP_FlAG = 0;
	public static final int USERS_GROUP_FLAG = 1;

	public static enum CODE_TYPE {
		JAVA("java"), PYTHON("py"), MATLAB("m"), R("r");

		String text;

		public String getText() {
			return text;
		}

		private CODE_TYPE(String text) {
			this.text = text;
		}

		public static CODE_TYPE parse(String text) {
			if (text.equalsIgnoreCase(JAVA.getText())) {
				return JAVA;
			}
			if (text.equalsIgnoreCase(PYTHON.getText())) {
				return PYTHON;
			}
			if (text.equalsIgnoreCase(MATLAB.getText()) || text.equalsIgnoreCase("MATLAB")) {
				return MATLAB;
			}
			if (text.equalsIgnoreCase(R.getText())) {
				return R;
			}
			return MATLAB;
		}

	}

	public static enum RUNNING_STATUS {
		WAIT_RUNNING("等待执行"), RUNNING("正在执行"), RUNNING_FAIL_TIMEOUT("程序超时执行失败"), RUNNING_FAIL_INTERNALERROR(
				"程序内部错误执行失败"), RUNNING_FAIL_UNKNOWN("程序未知错误执行失败"), RUNNING_SUCCESS("执行成功");

		String text;

		public String getText() {
			return text;
		}

		private RUNNING_STATUS(String text) {
			this.text = text;
		}

		public static RUNNING_STATUS parse(int i) {
			if (i == WAIT_RUNNING.ordinal()) {
				return WAIT_RUNNING;
			}
			if (i == RUNNING.ordinal()) {
				return RUNNING;
			}
			if (i == RUNNING_FAIL_TIMEOUT.ordinal()) {
				return RUNNING_FAIL_TIMEOUT;
			}
			if (i == RUNNING_FAIL_INTERNALERROR.ordinal()) {
				return RUNNING_FAIL_INTERNALERROR;
			}
			if (i == RUNNING_FAIL_UNKNOWN.ordinal()) {
				return RUNNING_FAIL_UNKNOWN;
			}
			if (i == RUNNING_SUCCESS.ordinal()) {
				return RUNNING_SUCCESS;
			}
			return null;
		}
	}

	public static void main(String args[]) {
		System.out.println(RUNNING_STATUS.WAIT_RUNNING.getText());
	}

}
