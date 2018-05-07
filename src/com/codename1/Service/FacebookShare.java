package com.codename1.Service;

import com.codename1.facebook.FaceBookAccess;
import com.codename1.io.NetworkEvent;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import java.io.IOException;
/**
 *
 * @author Fenina Malek
 */
public class FacebookShare {
    public static String token = "EAACEdEose0cBAKIrBtop89Iu83gZAc9Knd3fl4AkzvLcqonMTF4xzc0EZAM29DvR7mkTgYDvRpYNu4VceC5tMas1wVuykd7LjZCddsDEwlT4WZAlQQYGe2lmt2NZCUfAGCpN0szfGZBrCWe0s1gX3Q9dL2OszJkSi5g5nwTP5m2TEXzQjhZCb5u2cWUBVH48gtSbh3Js7VbuAZDZD";
    public FacebookShare(String token) {
        FaceBookAccess.setToken(token);
    }
    
    public void share(String text) throws IOException {
	FaceBookAccess.getInstance().addResponseCodeListener(new ActionListener() {

	    @Override
	    public void actionPerformed(ActionEvent evt) {
		NetworkEvent ne = (NetworkEvent) evt;
		int code = ne.getResponseCode();
		FaceBookAccess.getInstance().removeResponseCodeListener(this);
	    }
	});
	FaceBookAccess.getInstance().postOnWall("me", text);
    }
    
}
