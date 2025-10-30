package practice_api_senior.requests.skelethon.interfaces;

import io.restassured.common.mapper.TypeRef;
import practice_middle.models.BaseModel;

import java.util.List;

public interface CrudEndpointInterface {
      Object post (BaseModel baseModel);
      Object get (long id);
      Object get ();
      Object update (BaseModel baseModel);
      Object delete (long id);

}
