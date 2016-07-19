package com.mli.crown.mine.model;

import cn.bmob.v3.BmobObject;

/**
 * Created by crown on 2016/7/12.
 */
public class User extends BmobObject {

	public String userId;
	public String userName;
	public String password;
	public String birthday;
	public int age;
	public String location;
	public String description;
	public int state;//1 online 0 logout 2 busy

	public User() {
		super();
	}

	public User(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
		this.state = 1;
	}

	public User(String userId, String userName, String birthday, int age, String location, String description){
		super();
		this.userId = userId;
		this.userName = userName;
		this.birthday = birthday;
		this.age = age;
		this.location = location;
		this.description = description;
	}

}
