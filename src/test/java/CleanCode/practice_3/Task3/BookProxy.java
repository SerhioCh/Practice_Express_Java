package CleanCode.practice_3.Task3;

public class BookProxy implements VirtualBook {
    private  String title;
    private  String author;
    private  String description;

    private  Book realBook = null;

    public BookProxy(String title, String author, String description) {
        this.title = title;
        this.author = author;
        this.description = description;
    }

    private  void loadBook(){
        if(realBook==null){
            realBook = new Book.BookBuilder()
                    .setAuthor(author)
                    .setTitle(title)
                    .setDescription(description)
                    .build();
        }
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
        loadBook();
        return  realBook.getContent();
        }
    }

