package com.example.it_corgi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

import com.example.it_corgi.adapter.CategoryAdapter;
import com.example.it_corgi.adapter.CourseAdapter;
import com.example.it_corgi.model.Category;
import com.example.it_corgi.model.Course;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView categoryRecycler, courseRecycler;
    CategoryAdapter categoryAdapter;
    CourseAdapter courseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Category> categoryList = new ArrayList<>();
        categoryList.add(new Category(1, "Игры")); // можно добавить дополнительные категории
        categoryList.add(new Category(2, "Сайты"));
        categoryList.add(new Category(3, "Языки"));
        categoryList.add(new Category(4, "Прочее"));

        setCategoryRecycler(categoryList);

        List<Course> courseList = new ArrayList<>();
        courseList.add(new Course(1, "java", "Профессия Java\nразработчик", "1 сентября", "junior", "#424345", "9-месячная программа обучения, во время которой ученик получает базовые знания алгоритмов, на практике освоит язык Java и сможет создавать универсальные программы для большинства современных платформ.")); // прописываем курсы
        courseList.add(new Course(2, "python", "Профессия Python\nразработчик", "1 сентября", "junior", "#9FA52D", "9-месячная программа обучения, во время которой ученик на практике научится понимать фундаментальные алгоритмы и использовать их для написания сайтов, приложений, нейросетей иTelegram-бота."));
        courseList.add(new Course(3, "front", "Профессия Frontend\nразработчик", "1 августа", "junior", "#F1BF26", "9-месячная программа обучения, во время которой ученик получает базовые знания и на практике учится создавать сайты и приложения, проектировать интерфейсы и работать со сложными инструментами Frontend-разработчика."));
        courseList.add(new Course(4, "cplusplus", "Профессия С++\nразработчик", "1 октября", "junior", "#669AD3", "9-месячная программа обучения, во время которой ученик осваивает создание программы, игры, драйвера для устройств, изучает основы этого языка и на практике реализовывает графические интерфейсы."));
        setCourseRecycler(courseList);
    }
    private void setCourseRecycler(List<Course> courseList){
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);

        courseRecycler = findViewById(R.id.courseRecycler);
        courseRecycler.setLayoutManager(layoutManager);

        courseAdapter = new CourseAdapter(this, courseList);
        courseRecycler.setAdapter(courseAdapter);
    }
    private void setCategoryRecycler(List<Category> categoryList){

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);

        categoryRecycler = findViewById(R.id.categoryRecycler);
        categoryRecycler.setLayoutManager(layoutManager);

        categoryAdapter = new CategoryAdapter(this, categoryList);
        categoryRecycler.setAdapter(categoryAdapter);

    }
}
