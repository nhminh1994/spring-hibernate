package minh.training.springhibernate.customtags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class PageNavitionTag extends SimpleTagSupport {
	private int current;
	private int max;
	@Override
    public void doTag() throws JspException, IOException {
        final JspWriter writer = getJspContext().getOut();
        String first = "<button id=\"first\" type=\"button\" value=\"" + 1 + "\" class=\"pageNav btn btn-default\"	><<</button>"; 
        String last = "<button id=\"last\" type=\"button\" value=\"" + max + "\" class=\"pageNav btn btn-default\">>></button>";
        String next = "<button id=\"next\" type=\"button\"  value=\"" + (current+1) + "\" class=\"pageNav btn btn-default\">></button>";
        String previous = "<button id=\"previous\" type=\"button\"  value=\"" + (current-1) + "\" class=\"pageNav btn btn-default\"><</button>";
        String currentPage = "<input id=\"curpageno\" type=\"button\" value=\"" + current + "\" class=\"pageNav btn btn-default\" disabled>";
        String nextPage = "<input id=\"nextpageno\" type=\"button\" value=\"" + (current+1) + "\" class=\"pageNav btn btn-default\">";
        String previousPage = "<input id=\"prevpageno\" type=\"button\" value=\"" + (current-1) + "\" class=\"pageNav btn btn-default\">";
        StringBuilder tag = new StringBuilder();
        if (current == 1 && current < max){
        	tag.append(currentPage);
        	tag.append(nextPage);
        	tag.append(next);
        	tag.append(last);
        }
        else if (current == max){
        	if (max != 1){
        		tag.append(first);
        		tag.append(previous);
        		tag.append(previousPage);
        	}
        	tag.append(currentPage);
        }
        else {
        	tag.append(first);
        	tag.append(previous);
        	tag.append(previousPage);
        	tag.append(currentPage);
        	tag.append(nextPage);
        	tag.append(next);
        	tag.append(last);
        } 
        writer.print(tag.toString());
    }
	public void setCurrent(int current) {
		this.current = current;
	}
	public void setMax(int max) {
		this.max = max;
	}
}
