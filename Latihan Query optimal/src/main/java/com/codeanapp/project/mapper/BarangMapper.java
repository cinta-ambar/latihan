package com.codeanapp.project.mapper;

import com.codeanapp.project.model.Barang;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BarangMapper {

    void bulkInsertBarang(@Param("barangList") List<Barang> list);

    List<Barang> getAllBarang(@Param("offset") int offset,
                              @Param("limit") int limit,
                              @Param("sortField") String sorField,
                              @Param("sortOrder") String sortOrder);
    Integer countBarang();
}
