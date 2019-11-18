/**
 * Copyright 2018 人人开源 http://www.renren.io
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.example.mall.app.common.result;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mall.app.common.constant.MybatisConstant;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

import java.util.stream.Stream;

/**
 * 查询参数
 */
public class Q<D> {
    private static final long serialVersionUID = 1L;

    /**
     * 当前页码
     */
    @Setter
    @Getter
    private long pageIndex = 1;
    /**
     * 每页条数
     */
    @Setter
    @Getter
    private long pageSize = 10;

    @Setter
    @Getter
    private String orderBy;

    @Setter
    @Getter
    private D data;

    /**
     * @param <T>
     * @return
     */
    public <T> IPage<T> getPage() {
        Page page = new Page();
        page.setSize(pageSize);
        page.setCurrent(pageIndex);
        if (StringUtils.isNotBlank(orderBy)) {
            Stream.of(StringUtils.split(orderBy.trim(), ",")).map(m -> m.trim()).forEach(i -> {
                int idx = i.lastIndexOf(" ");
                if (idx > -1) {
                    String column = i.substring(0, idx);
                    String orderFlag = i.substring(idx + 1);
                    if (MybatisConstant.ORDER_BY_DESC.equalsIgnoreCase(orderFlag)) {
                        page.addOrder(OrderItem.desc(column));
                    } else {
                        page.addOrder(OrderItem.asc(column));
                    }
                } else {
                    page.addOrder(OrderItem.asc(i));
                }
            });
        }
        return page;
    }

}
