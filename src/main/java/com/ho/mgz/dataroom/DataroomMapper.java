package com.ho.mgz.dataroom;

import java.util.List;

public interface DataroomMapper {
	public abstract List<DataroomDate> showDataroom(DataroomDate dd);
	public abstract int uploadData(DataroomDate dd); 
	public abstract String getFileName(DataroomDate dd);
	public abstract int deleteFile(DataroomDate dd);
}
