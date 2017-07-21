package com.courseratingsystem.web.vo;

import java.util.ArrayList;
import java.util.List;

import com.courseratingsystem.web.domain.Teacher;
import com.courseratingsystem.web.object.CourseOverview;
import com.courseratingsystem.web.object.CourseOverviewPlusTeacher;

public class CoursePage {
	private int pageSize;//每页显示数量
	private int currentPage;//当前页
	private int totalCount;//总条数
	private int totalPage;
	public CoursePage(int pageSize, int currentPage, int totalCount,
			int totalPage, List<CourseOverview> list) {
		super();
		this.pageSize = pageSize;
		this.currentPage = currentPage;
		this.totalCount = totalCount;
		this.totalPage = totalPage;
		this.list = new ArrayList<>();
		for(CourseOverview tmpCourse : list) {
			this.list.add(new CourseOverviewPlusTeacher(tmpCourse));
		}
	}
	private List<CourseOverviewPlusTeacher> list;
	public List<CourseOverviewPlusTeacher> getList() {
		return list;
	}
	public void setList(List<CourseOverviewPlusTeacher> list) {
		this.list = list;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
}
