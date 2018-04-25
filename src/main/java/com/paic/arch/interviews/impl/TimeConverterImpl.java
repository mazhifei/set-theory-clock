package com.paic.arch.interviews.impl;

import com.paic.arch.interviews.TimeConverter;

public class TimeConverterImpl implements TimeConverter {

	@Override
	public String convertTime(String aTime) {
		if(aTime==null) {
			throw new IllegalArgumentException("输入时间不能为空，请输入：HH:mm:ss格式时间");
		}
		String timereg = "^([0-1][0-9]|[2][0-4]):([0-5][0-9]):([0-5][0-9])$";
		if(aTime.matches(timereg)) {
			throw new IllegalArgumentException("输入时间格式不对，请输入：HH:mm:ss格式时间");
		}
		String nums[] = aTime.split(":");
		int hour = Integer.valueOf(nums[0]);
		int minute = Integer.valueOf(nums[1]); 
		int second = Integer.valueOf(nums[2]);
		
		String ret = displayLightStatus(hour, minute, second);
		return ret;
	}
	
	/**
	 * 按照规则输出
	 * @param hour 小时
	 * @param minute 分钟
	 * @param second 秒
	 * @return
	 */
	private String displayLightStatus(int hour, int minute, int second) {
		StringBuffer buffer = new StringBuffer();
		// 上面的亮亮为1，不亮为0
		if ((second % 2) == 1) {
			buffer.append("O\r\n");
		} else {
			buffer.append("Y\r\n");
		}
		// 小时和分钟两层亮灯数量，就是除以5取整为第一层，余数为第二层
		int num = 5;
		//小时第一层
		int middleFirstfloornum = hour / num;
		for (int i = 0; i < num-1; i++) {
			buffer.append(middleFirstfloornum>i?"R":"O");
		}
		buffer.append("\r\n");
		//小时第二层
		int middleSecondfloornum = hour % 5;
		for (int i = 0; i < num-1; i++) {
			buffer.append(middleSecondfloornum>i?"R":"O");
			
		}
		buffer.append("\r\n");
		// 分钟第一层
		int bottomFirstfloornum = minute / num;
		for (int i = 0; i < 11; i++) {
			if(bottomFirstfloornum>i) {
				buffer.append((i+1) % 3 == 0 ? "R" : "Y");
			}else {
				buffer.append("O");
			}
		}
		buffer.append("\r\n");
		// 分钟第二层
		int bottomSecondfloornum = minute % num;
		for (int i = 0; i < num-1; i++) {
			buffer.append(bottomSecondfloornum>i?"Y":"O");
		}
		return buffer.toString();
	}

	public String convertTime21(String a) {
		// TODO Auto-generated method stub
		String s="123";
		return null;
	}

}
