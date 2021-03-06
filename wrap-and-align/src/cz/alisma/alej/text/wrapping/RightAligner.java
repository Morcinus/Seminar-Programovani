package cz.alisma.alej.text.wrapping;

import java.util.List;

public class RightAligner implements Aligner{
	private int width;
	
    @Override
    public String format(List<String> words) {
        StringBuilder result = new StringBuilder();
        
        boolean first = true;
        for (String w : words) {
            if (!first) {
                result.append(" ");
            } else {
                first = false;
            }
            result.append(w);
        }
        
        int stringLength = result.length();
        
        
        for(int i = 0; i <= width - stringLength; i++) {
        	result.insert(0, " ");
        }
        
        return result.toString();
    }
    
    public RightAligner(int w) {
    	width = w;
    }
}
