package com.ho.mgz.gallery;

import java.util.List;

import com.ho.mgz.login.Member;

public interface GalleryMapper {
	public abstract int writeGallery(GalleryWriting gw);
	public abstract int setGalleryBoardCount(SearchOption so);
	public abstract int regAIData(AIData ad);
	public abstract List<GalleryWriting> getGallery(SearchOption so);
	public abstract GalleryWriting showUpdateGallery(GalleryWriting gw);
	public abstract int deleteGallery(GalleryWriting gw);
	public abstract int updateGallery(GalleryWriting gw);
	public abstract int countUserGalleryBoard(Member m);
	public abstract int writeGReply(GalleryReply gr);
	public abstract List<GalleryReply> showGReply(GalleryReply gr);
}
