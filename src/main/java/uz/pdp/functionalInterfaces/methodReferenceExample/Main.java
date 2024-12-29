package uz.pdp.functionalInterfaces.methodReferenceExample;

import java.time.LocalDateTime;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
       /* List<Integer> numbers = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            numbers.add(random.nextInt(10, 400));
        }
        System.out.println(numbers);

        Consumer<List<Integer>> sortedList = Collections::sort; // statis method reference;
       *//* Consumer<List<Integer>> sortedList = (list)-> {
            Collections.sort(list);
        };*//*
        sortedList.accept(numbers);
        System.out.println(numbers);


        Main main = new Main();
        Function<String, Integer> nn = main::toInteger;  // instant method;
       // Function<String, Integer> nn = (s) -> main.toInteger(s);
        System.out.println(nn.apply("12"));

        Function<String, Integer> mm = s -> s.length();
        System.out.println(mm.apply("123"));*/



      //  todo: pastdagi codeni Lambda bilan qisqartirilgan shakli.// constructorlardan method reference sifatida foydalanish deyiladi;
        Function<UserRegisterDTO, User> toUserMapper = User::new;

       /* Function<UserRegisterDTO, User> toUserMapper = (dto)->{
            User user = new User();
            user.setUsername(dto.getUserName());
            user.setPassword(dto.getPassword());
            user.setRole("User");
            user.setCreatedAt(LocalDateTime.now());
            return user;
        };*/
        UserRegisterDTO userRegisterDTO = new UserRegisterDTO("john", "123");
        User user = toUserMapper.apply(userRegisterDTO);
        System.out.println(user);

    }

    public int toInteger(String s) {
        return Integer.parseInt(s);
    }
}
