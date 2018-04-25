package com.paic.arch.interviews.impl;

import com.paic.arch.interviews.TimeConverter;

public class TimeConverterImpl implements TimeConverter {

	@Override
	public String convertTime(String aTime) {
		if(aTime==null) {
			throw new IllegalArgumentException("����ʱ�䲻��Ϊ�գ������룺HH:mm:ss��ʽʱ��");
		}
		String timereg = "^([0-1][0-9]|[2][0-4]):([0-5][0-9]):([0-5][0-9])$";
		if(aTime.matches(timereg)) {
			throw new IllegalArgumentException("����ʱ���ʽ���ԣ������룺HH:mm:ss��ʽʱ��");
		}
		String nums[] = aTime.split(":");
		int hour = Integer.valueOf(nums[0]);
		int minute = Integer.valueOf(nums[1]); 
		int second = Integer.valueOf(nums[2]);
		
		String ret = displayLightStatus(hour, minute, second);
		return ret;
	}
	
	/**
	 * ���չ������
	 * @param hour Сʱ
	 * @param minute ����
	 * @param second ��
	 * @return
	 */
	private String displayLightStatus(int hour, int minute, int second) {
		StringBuffer buffer = new StringBuffer();
		// ���������Ϊ1������Ϊ0
		if ((second % 2) == 1) {
			buffer.append("O\r\n");
		} else {
			buffer.append("Y\r\n");
		}
		// Сʱ�ͷ��������������������ǳ���5ȡ��Ϊ��һ�㣬����Ϊ�ڶ���
		int num = 5;
		//Сʱ��һ��
		int middleFirstfloornum = hour / num;
		for (int i = 0; i < num-1; i++) {
			buffer.append(middleFirstfloornum>i?"R":"O");
		}
		buffer.append("\r\n");
		//Сʱ�ڶ���
		int middleSecondfloornum = hour % 5;
		for (int i = 0; i < num-1; i++) {
			buffer.append(middleSecondfloornum>i?"R":"O");
			
		}
		buffer.append("\r\n");
		// ���ӵ�һ��
		int bottomFirstfloornum = minute / num;
		for (int i = 0; i < 11; i++) {
			if(bottomFirstfloornum>i) {
				buffer.append((i+1) % 3 == 0 ? "R" : "Y");
			}else {
				buffer.append("O");
			}
		}
		buffer.append("\r\n");
		// ���ӵڶ���
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
