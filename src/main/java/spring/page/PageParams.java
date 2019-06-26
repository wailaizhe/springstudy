package spring.page;

import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;

public class PageParams {
	
	private Integer pageSize=10;
	private Integer page=1;
	private Boolean useFlag=true;
	private Boolean checkFlag;
	private Integer totalPage;
	private Integer total;

	
	public static void main(String[] args) {
		PageParams pageParams=new PageParams();
		MetaObject metaStatementHandler = SystemMetaObject.forObject(pageParams);
	    String sql = (String) metaStatementHandler.getValue("keyUser.name2");
	    metaStatementHandler.setValue("keyUser.name2", "wangwu");
	    sql = (String) metaStatementHandler.getValue("keyUser.name2");
		System.err.println(sql);		
	}

	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Boolean getUseFlag() {
		return useFlag;
	}
	public void setUseFlag(Boolean useFlag) {
		this.useFlag = useFlag;
	}
	public Boolean getCheckFlag() {
		return checkFlag;
	}
	public void setCheckFlag(Boolean checkFlag) {
		this.checkFlag = checkFlag;
	}
	

}
