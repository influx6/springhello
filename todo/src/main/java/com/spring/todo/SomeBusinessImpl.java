package com.spring.todo;

public class SomeBusinessImpl {
	private DataService dataService;

	SomeBusinessImpl(DataService dataService){
		this.dataService = dataService;
	}

	public int findRecordsWithUser() {
		int[] allRecordIds = this.dataService.getAllRecords();
		int highestRecordId = Integer.MIN_VALUE;
		for (int recordId: allRecordIds) {
			if (recordId > highestRecordId) {
				highestRecordId = recordId;
			}
		}
		return highestRecordId;
	}
}
