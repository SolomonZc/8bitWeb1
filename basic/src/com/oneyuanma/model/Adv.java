package com.oneyuanma.model;

/*
 * 轮播图
 * 
 */
public class Adv {
	private Integer id;

    //图片名称
    private String name;

    //图片描述
    private String describ;

    //图片路径
    private String url;

    //图片排序
    private Integer grade;
    
	public Integer getId() {
        return id;
    }
    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jbbs_user.id
     *
     * @param id the value for jbbs_user.id
     *
     * @mbggenerated Fri May 05 14:00:15 CST 2017
     */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jbbs_user.name
     *
     * @return the value of jbbs_user.name
     *
     * @mbggenerated Fri May 05 14:00:15 CST 2017
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jbbs_user.name
     *
     * @param name the value for jbbs_user.name
     *
     * @mbggenerated Fri May 05 14:00:15 CST 2017
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jbbs_user.name
     *
     * @return the value of jbbs_user.name
     *
     * @mbggenerated Fri May 05 14:00:15 CST 2017
     */
    public String getDescrib() {
        return describ;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jbbs_user.name
     *
     * @param name the value for jbbs_user.name
     *
     * @mbggenerated Fri May 05 14:00:15 CST 2017
     */
    public void setDescrib(String describ) {
        this.describ = describ;
    }
    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jbbs_user.name
     *
     * @return the value of jbbs_user.name
     *
     * @mbggenerated Fri May 05 14:00:15 CST 2017
     */
    public String getUrl() {
        return url;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jbbs_user.name
     *
     * @param name the value for jbbs_user.name
     *
     * @mbggenerated Fri May 05 14:00:15 CST 2017
     */
    public void setUrl(String url) {
        this.url = url;
    }
    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jbbs_user.name
     *
     * @return the value of jbbs_user.name
     *
     * @mbggenerated Fri May 05 14:00:15 CST 2017
     */
    public Integer getGrade() {
        return grade;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jbbs_user.name
     *
     * @param name the value for jbbs_user.name
     *
     * @mbggenerated Fri May 05 14:00:15 CST 2017
     */
    public void setGrade(Integer grade) {
        this.grade = grade;
    }
}
