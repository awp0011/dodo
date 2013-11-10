package org.wpgn.dodo.commons;

public class SystemConfigInit {
	public void configInit() {
		Constants.ROOT_PATH = System.getProperty("webapp.root.dodo");
	}
}
