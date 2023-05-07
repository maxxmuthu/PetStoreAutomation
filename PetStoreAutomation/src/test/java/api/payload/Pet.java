package api.payload;

import java.util.List;
import java.util.Map;

public class Pet {
	
	    public long id;
	    public Map<String, Object> category;
	    public String name;
	    public List<String> photoUrls;
	    public List<Map<String, Object>> tags;
	    public String status;

	    public long getId() {
	        return id;
	    }

	    public void setId(long id) {
	        this.id = id;
	    }

	    public Map<String, Object> getCategory() {
	        return category;
	    }

	    public void setCategory(Map<String, Object> category) {
	        this.category = category;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public List<String> getPhotoUrls() {
	        return photoUrls;
	    }

	    public void setPhotoUrls(List<String> photoUrls) {
	        this.photoUrls = photoUrls;
	    }

	    public List<Map<String, Object>> getTags() {
	        return tags;
	    }

	    public void setTags(List<Map<String, Object>> tags) {
	        this.tags = tags;
	    }

	    public String getStatus() {
	        return status;
	    }

	    public void setStatus(String status) {
	        this.status = status;
	    }


}
