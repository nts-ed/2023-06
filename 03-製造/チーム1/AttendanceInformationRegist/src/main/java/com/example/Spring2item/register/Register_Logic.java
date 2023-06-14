package com.example.Spring2item.register;

public class Register_Logic {
	String[] statuses = {"出勤","退勤","欠勤"};
	int[] status_number = {1,2,3};
	
	public void register()
	{
		Register_Update_dto dto = new Register_Update_dto();
		for(int i = 0; i < statuses.length - 1; i++)
		{
			dto.status_id = status_number[Integer.parseInt(statuses)];
		}
	}
}
