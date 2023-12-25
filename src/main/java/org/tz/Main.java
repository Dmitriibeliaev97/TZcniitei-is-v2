package org.tz;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws Exception {
        File file = new File("C:\\Users\\Пользователь\\IdeaProjects\\TZ\\src\\main\\resources\\AS_ADDR_OBJ.XML");

        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        List<Obj> objs = xmlMapper.readValue(file, new TypeReference<List<Obj>>() {
        });

        List<Integer> requiredIds = Arrays.asList(1422396, 1450759, 1449192, 1451562);
        LocalDate date = LocalDate.of(2010, 1, 1);

        List<Obj> filteredItems = objs.stream()
                .filter(i -> (i.getStartDate().isEqual(date) || !i.getStartDate().isAfter(date)) &&
                        (i.getEndDate().isEqual(date) || !i.getEndDate().isBefore(date)))
                .filter(i -> requiredIds.contains(i.getObjectId()))
                .collect(Collectors.toList());

        filteredItems.forEach(System.out::println);

    }
}