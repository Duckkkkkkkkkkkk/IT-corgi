package com.example.it_corgi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.content.Intent;

import java.util.List;

import com.example.it_corgi.adapter.CategoryAdapter;
import com.example.it_corgi.adapter.CourseAdapter;
import com.example.it_corgi.model.Category;
import com.example.it_corgi.model.Course;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView categoryRecycler, courseRecycler;
    CategoryAdapter categoryAdapter;
    static CourseAdapter courseAdapter;
    static List<Course> courseList = new ArrayList<>();
    static List<Course> fullcourseList = new ArrayList<>();

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

        courseList.add(new Course(1, "java", "Профессия Java\nразработчик", "1 сентября", "junior", "#424345", "9-месячная программа обучения, во время которой ученик получает базовые знания алгоритмов, на практике освоит язык Java и сможет создавать универсальные программы для большинства современных платформ.", 3, "4225")); // прописываем курсы
        courseList.add(new Course(2, "python", "Профессия Python\nразработчик", "1 сентября", "junior", "#9FA52D", "9-месячная программа обучения, во время которой ученик на практике научится понимать фундаментальные алгоритмы и использовать их для написания сайтов, приложений, нейросетей иTelegram-бота.", 3, "4225"));
        courseList.add(new Course(3, "front", "Профессия Frontend\nразработчик", "1 августа", "junior", "#F1BF26", "9-месячная программа обучения, во время которой ученик получает базовые знания и на практике учится создавать сайты и приложения, проектировать интерфейсы и работать со сложными инструментами Frontend-разработчика.", 2, "4062"));
        courseList.add(new Course(4, "cplusplus", "Профессия С++\nразработчик", "1 октября", "junior", "#669AD3", "9-месячная программа обучения, во время которой ученик осваивает создание программы, игры, драйвера для устройств, изучает основы этого языка и на практике реализовывает графические интерфейсы.", 3, "4000"));

        fullcourseList.addAll(courseList); // список, состоящий из всех курсов изначально

        setCourseRecycler(courseList);
    }

    public void openShoppingCart(View view) {
        Intent intent = new Intent(this, OrderPage.class);
        startActivity(intent);
    }
    public void openAboutPage(View view) {
        Intent intent1 = new Intent(this, About.class);
        startActivity(intent1);
    }
    public void openContactsPage(View view) {
        Intent intent2 = new Intent(this, Contacts.class);
        startActivity(intent2);
    }
    public void openMainPage(View view) { // мб надо удалить??? мб баги из-за этого
        Intent intent3 = new Intent(this, MainActivity.class);
        startActivity(intent3);
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

    public static void showCoursesByCategory(int category) {

        courseList.clear();
        courseList.addAll(fullcourseList);

        List<Course> filterCourses = new ArrayList<>();

        for(Course c : courseList) { // перебираем категории из курслист
            if(c.getCategory() == category) // и ищем совпадения с категорией, которая передается в метод
                filterCourses.add(c);
        }

        courseList.clear(); // чтобы не забивалась память
        courseList.addAll(filterCourses); // добавляем только фильтрованные курсы

        courseAdapter.notifyDataSetChanged(); // берет новое текущее значение значение списка и обновляет RecyclerView

    }
}
