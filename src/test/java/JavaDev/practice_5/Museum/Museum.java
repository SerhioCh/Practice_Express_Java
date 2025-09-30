package JavaDev.practice_5.Museum;

public class Museum {
    Exhibit exhibit;

    void setExhibit(Exhibit exhibit){
        this.exhibit = exhibit;
    }

    void  showExhibit(){
        exhibit.conditions();
        exhibit.history();
    }


}
