package data;

import java.io.BufferedReader;
import java.io.File;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class data_Dictionary {
	private Map<String, String> data=new TreeMap<String, String>();
	private Set<String> listSuggest = new TreeSet<String>();
	private Set<String> returnSuggest= new TreeSet<String>();
	private boolean is_RemovedDocument=false;
	public data_Dictionary() {
		this.addAWord("hello", "xin chào");
		this.addAWord("you", "bạn");
		this.addAWord("configure", "cấu hình");
		this.addAWord("explicit", "rõ ràng,dứt khoắt");
		this.addAWord("overview", "nhìn tổng thể");
		this.addAWord("exist", "tồn tại");
		this.addAWord("effect", "ảnh hưởng");
		this.addAWord("error","lỗi");
		this.addAWord("protocol", "giao thức");
		this.addAWord("check","kiểm tra");
	}
	public Set<String> suggestWord(String s) {
		Set<String> removedSuggest= new HashSet<String>();
		System.out.println(this.listSuggest.size());
		if(this.returnSuggest.isEmpty()||this.is_RemovedDocument) {
			for (String string : this.listSuggest) {
				if(string.startsWith(s))returnSuggest.add(string);
			}
			is_RemovedDocument=false;
		}else {
			for (String string : returnSuggest) {
				if(!(string.startsWith(s))) {
						removedSuggest.add(string);
				}
			}
			for (String string : removedSuggest) {
				this.returnSuggest.remove(string);
			}
		}
			return returnSuggest;
	}
	public String translate(String s) {
		return this.data.get(s);
	}
	public boolean isRemovedDocument() {
		return this.is_RemovedDocument=true;
	}
	public void addAWord(String key,String value) {
		this.data.put(key, value);
		this.listSuggest.add(key);
	}
	public int getDataSize() {
		return this.data.size();
	}
}
