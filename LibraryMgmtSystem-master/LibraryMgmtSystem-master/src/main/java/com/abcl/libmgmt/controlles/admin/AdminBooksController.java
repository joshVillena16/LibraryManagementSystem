/* bcabcl
 *
 * Copyright (c) 2018 Tushar Girase All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * ecabcl
 */
package com.abcl.libmgmt.controlles.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.abcl.libmgmt.models.Book;
import com.abcl.libmgmt.service.IBookService;

/**
 *
 */
@Controller
public class AdminBooksController {

    @Autowired
    IBookService bookService;

    @GetMapping("admin/books")
    public ModelAndView getAllBooksPage() {
        List<Book> booksList = bookService.getAllBooks();
        ModelAndView mv = new ModelAndView("admin/library/allBooks");
        mv.addObject("books", booksList);
        return mv;
    }

    @GetMapping("admin/booksajax")
    public ModelAndView getAllBooksAjaxPage() {
        List<Book> booksList = bookService.getAllBooks();
        ModelAndView mv = new ModelAndView("admin/library/allBooksAjax");
        mv.addObject("books", booksList);
        return mv;
    }

}
