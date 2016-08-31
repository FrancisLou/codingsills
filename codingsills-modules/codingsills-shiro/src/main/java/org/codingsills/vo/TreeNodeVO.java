package org.codingsills.vo;

import java.io.Serializable;

/**
 * 类功能描述
 * TreeNodeVO.java
 *
 * @date 2016年5月26日
 * 
 * @author Saber
 */
public class TreeNodeVO implements Serializable {

    private static final long serialVersionUID = -1457326724538252837L;

    private boolean checked = false;

    private boolean disabled = false;

    private boolean expanded = false;

    private boolean selected = false;

    /**
     * TreeVO.java 默认构造
     */
    public TreeNodeVO(){}

    public boolean isChecked(){
        return checked;
    }

    public void setChecked(boolean checked){
        this.checked = checked;
    }

    public boolean isDisabled(){
        return disabled;
    }

    public void setDisabled(boolean disabled){
        this.disabled = disabled;
    }

    public boolean isExpanded(){
        return expanded;
    }

    public void setExpanded(boolean expanded){
        this.expanded = expanded;
    }

    public boolean isSelected(){
        return selected;
    }

    public void setSelected(boolean selected){
        this.selected = selected;
    }
}
