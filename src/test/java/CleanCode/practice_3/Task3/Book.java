package CleanCode.practice_3.Task3;

public class Book implements VirtualBook {
    private  String title;
    private  String author;
    private  String description;
    private  String content;

    public    Book(BookBuilder boobBuilder){
        this.title = boobBuilder.title;
        this.author = boobBuilder.author;
        this.description = boobBuilder.description;
        this.content = boobBuilder.content;
    }

    @Override
    public String getAuthor() {
        return author;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String getContent() {
        return content;
    }


   public static  class BookBuilder {
        private  String title;
        private  String author;
        private  String description;
        private  String content;

        public BookBuilder setTitle(String title) {
            this.title = title;
            return  this;
        }

        public BookBuilder setAuthor(String author) {
            this.author = author;
            return  this;
        }

        public BookBuilder setDescription(String description) {
            this.description = description;
            return  this;
        }

        public BookBuilder setContent(String content) {
            this.content = content;
            return  this;
        }

        public  Book build(){
            return  new Book(this);
        }
    }

}
