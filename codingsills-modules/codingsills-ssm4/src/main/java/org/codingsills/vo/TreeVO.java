/**
 * 创建于: 2015年11月26日 下午4:41:17<br>
 * 所属项目:codingfans-ssm4 文件名称:TreeVO.java 作者:Saber 版权信息:
 */
package org.codingsills.vo;

import java.io.Serializable;
import java.util.List;

import org.codingsills.model.SysResource;

/**
 * 类功能描述
 * TreeVO.java
 *
 * @date 2015年11月26日 Saber
 * 
 * @author Saber
 * @version 0.1.0
 */
public class TreeVO implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 322454594305510543L;

    private Long id;

    private String text;

    private String icon;

    private String selectedIcon;

    private String color;

    private String backColor;

    private String selectable;

    private List<TreeVO> nodes;

    private String href;

    private TreeNodeVO state;

    public TreeVO(){}

    public TreeVO(SysResource menu){
        this.id = menu.getId();
        this.href = menu.getUrl();
        this.text = menu.getName();
        this.icon = menu.getIcon();
        this.color = "#000000";
        this.backColor = "#FFFFFF";
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getText(){
        return text;
    }

    public void setText(String text){
        this.text = text;
    }

    public String getIcon(){
        return icon;
    }

    public void setIcon(String icon){
        this.icon = icon;
    }

    public String getSelectedIcon(){
        return selectedIcon;
    }

    public void setSelectedIcon(String selectedIcon){
        this.selectedIcon = selectedIcon;
    }

    public String getColor(){
        return color;
    }

    public void setColor(String color){
        this.color = color;
    }

    public String getBackColor(){
        return backColor;
    }

    public void setBackColor(String backColor){
        this.backColor = backColor;
    }

    public String getSelectable(){
        return selectable;
    }

    public void setSelectable(String selectable){
        this.selectable = selectable;
    }

    public List<TreeVO> getNodes(){
        return nodes;
    }

    public void setNodes(List<TreeVO> nodes){
        this.nodes = nodes;
    }

    public String getHref(){
        return href;
    }

    public void setHref(String href){
        this.href = href;
    }

    public TreeNodeVO getState(){
        return state;
    }

    public void setState(TreeNodeVO state){
        this.state = state;
    }
}
