package org.fish.code.webdemo.controller;

import lombok.extern.slf4j.Slf4j;
import org.fish.code.webdemo.domain.ResultData;
import org.fish.code.webdemo.domain.Toy;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@RestController // restful web api
@Slf4j //logger annotation
@RequestMapping("/apis")
public class ToyController {
    //临时存储数据
    private Map<Long, Toy> toyMap = new HashMap<>();

    private Long currentId = 0L;

    @PostMapping("/toys")
    public ResultData<Toy> createOne(@RequestBody Toy toy) {
        log.info("Create a new toy:{}", toy);

        currentId++;
        toy.setId(currentId);
        toyMap.put(currentId, toy);


        return ResultData.success(toy);
    }

    @GetMapping("/toys")
    public ResultData<Collection<Toy>> getAll() {
        Collection<Toy> toys = toyMap.values();

        return ResultData.success(toys);
    }

    /**
     * 基于ID，获取toy对象.
     *
     * @param id
     * @return
     */
    @GetMapping("/toys/{id}")
    public ResultData<Toy> getOne(@PathVariable Long id,
                                  @RequestParam(name = "name", required = false) String name) {
        log.info("Get One Toy:{}, name:{}", id, name);

        Toy toy = this.toyMap.get(id);

        log.info("Toy Result:{}", toy);

        return ResultData.success(toy);
    }

    @GetMapping("/toys/query")
    public ResultData<Toy> getOne(@RequestParam("name") String name) {
        log.info("Get One Toy name:{}",  name);

        Toy toy= new Toy();
        for (Toy t: toyMap.values()) {
            if (t.getName().equals(name)) {
                toy = t;
                break;
            }
        }

        log.info("Toy Result:{}", toy);

        return ResultData.success(toy);
    }

    @PutMapping("/toys/{id}")
    public ResultData<Toy> updateOne(@PathVariable Long id, @RequestBody Toy toy) {
        log.info("Update toy id:{}, update body data:{}",id, toy);

        Toy oldToy = this.toyMap.get(id);

        oldToy.setName(toy.getName());
        if (toy.getDescription() != null) {
            oldToy.setDescription(toy.getDescription());
        }

        if (toy.getNum() != null) {
            oldToy.setNum(toy.getNum());
        }

        log.info("Updated toy:{}", toy);

        return ResultData.success(oldToy);
    }

    @DeleteMapping("/toys/{id}")
    public ResultData<Toy> deleteOne(@PathVariable("id") Long id) {
        log.info("delete one toy:{}", id);

        Toy toy = this.toyMap.remove(id);
        log.info("Removed Toy id:{}, data:{}", id, toy);

        return ResultData.success(toy);
    }

}
