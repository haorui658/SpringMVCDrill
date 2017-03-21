/**
 * Created by cdhaorui on 2017/3/21.
 */
var tabView = new YAHOO.widget.TabView();
var tabHeight;
//最多打开tab个数
var tabNum = 8;
init = function()
{
    tabView.appendTo('yuicontainer');
    addTab('0', '工作台', '/static/welcome.html');
}

addTab = function(id,label,src)
{
    //同一菜单只允许打开一次,多次打开视为切换tab页
    for(var tabIndex=0;tabIndex<tabView.get("tabs").length;tabIndex++){
        var tab=tabView.getTab(tabIndex);
        if(tab.get("id")==id){
            tabView.set('activeTab',tab,true);
            return;
        }
    }

    //if(document.getElementById("iFrame"+id))
    //{
    //是否一个ID链接只能打开一个tab
    //}
    //判断是否tab个数达到限定个数

    if(tabView.get("tabs").length == tabNum)
    {
        if(!confirm("打开窗口个数已经达到"+tabNum+"个,新开窗口将会关闭第一个窗口,是否继续?"))
        {
            return;
        }
        //删除第一个窗口
        tabView.removeTab(tabView.getTab("0"));
    }
    var labelText = label;
    var content = '<div class="iframe_container"><div id="tobarDiv'+id+'" class="tobarDiv"></div><iframe class="tabFrame" id="iFrame'+id+'" name="iFrame'+id+'" frameBorder=0 scrolling="auto" width="100%" height="100%" resizeable="yes"  src="'+src+'"></iframe></div>';
    var tab = new YAHOO.widget.Tab({ label: labelText,content:content });
    tabView.addTab(tab);
    tabView.set('activeTab',tab,true);
    tab.set('title',labelText);
    tab.set("id",id);
    tab.addListener('dblclick',dblClickEvent);
}
//双击TAB头关闭事件
function dblClickEvent(e)
{
    var tab=tabView.get('activeTab');
    var id=tab.get("id");
    document.getElementById("iFrame"+id).src="";
    tabView.removeTab(tab);
}

//获取当前TAB的resource_id
function getResourceId()
{
    if(tabView.get('activeTab'))
    {
        return tabView.get('activeTab').get("id");
    }
    else
    {
        return null;
    }

}

function setTobarDiv(id,content){
    /*            var tobarDiv=document.getElementById("tobarDiv"+id);
     if(tobarDiv!=null&&tobarDiv){
     tobarDiv.innerHTML=content;
     }*/
}

/**
 * 关闭菜单
 * tabId
 菜单编号
 * add: zhongfj 2012-08-08 taskId: 68913
 */
function closeTab(tabId)
{
    for(var tabIndex=0;tabIndex<tabView.get("tabs").length;tabIndex++){
        var tab=tabView.getTab(tabIndex);
        if(tab.get("id")==tabId){
            document.getElementById("iFrame"+tabId).src="";
            tabView.removeTab(tab);
            return;
        }
    }
}