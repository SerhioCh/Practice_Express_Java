package common.storage;

import practice_api_senior.requests.steps.UserSteps;
import practice_api_senior.requests.steps.UserStepsUiSenior;
import practice_middle.models.CreateUserRequest;
import practice_middle.models.CreateUserResponse;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class SessionStorage {
    private  static final ThreadLocal <SessionStorage> INSTANCE = ThreadLocal.withInitial(SessionStorage::new);

    private LinkedHashMap <CreateUserRequest , UserStepsUiSenior> userStepsMap = new LinkedHashMap<>();

    private  SessionStorage(){}

    public static SessionStorage getInstance() {
        return INSTANCE.get();
    }
    public static int userCount() {
        return INSTANCE.get().userStepsMap.size();
    }

    public  static void addUsers(List<CreateUserRequest> users) {
        for (CreateUserRequest user: users){
            INSTANCE.get().userStepsMap.put(user,new UserStepsUiSenior(user.getUsername(),user.getPassword()));
        }
    }

    public  static CreateUserRequest getUser(int number){
      return new ArrayList<>(INSTANCE.get().userStepsMap.keySet()).get(number-1);
    }
    public  static CreateUserRequest getUser(){
        return  getUser(1);
    }
    public  static UserStepsUiSenior getSteps (int number){
        return new ArrayList<>(INSTANCE.get().userStepsMap.values()).get(number-1);
    }
    public  static UserStepsUiSenior getSteps (){
        return  getSteps(1);
    }

    public  static  void  clear (){
        INSTANCE.get().userStepsMap.clear();
    }

}
