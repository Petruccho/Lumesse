package com.constans;

public enum PAUSE_LENGTH {
	MAX(60000), AVG(30000), SHORT(10000), MIN(5000), MODULE_WAIT(120000);

	private Integer value;

	private PAUSE_LENGTH(Integer value) {
		this.value = value;
	}

	public Integer value() {
		return this.value;
	}
}