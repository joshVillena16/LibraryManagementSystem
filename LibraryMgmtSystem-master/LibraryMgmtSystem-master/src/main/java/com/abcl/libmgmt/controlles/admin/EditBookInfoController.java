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

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.servlet.ModelAndView;

import com.abcl.libmgmt.models.Book;
import com.abcl.libmgmt.service.IBookService;

/**
 *
 */
@Controller
public class EditBookInfoController {

    @Autowired
    @Qualifier("bookValidator")
    Validator bookValidator;

    @InitBinder
    public void initbinder(WebDataBinder dataBinder) {
        dataBinder.setValidator(bookValidator);
    }

    @Autowired
    IBookService bookService;

    @GetMapping("/admin/library/editbookinfo/{isbin}")
    public ModelAndView getEditPage(@PathVariable("isbin") String isbinNo) {
        ModelAndView mv = new ModelAndView("admin/library/editbookinfo");
        Book book = bookService.findBookByIsbinNo(isbinNo);
        mv.addObject("book", book);
        return mv;
    }

    @PutMapping("/admin/library/editbookinfo/{isbin}")
    public ModelAndView updateBookInfo(@ModelAttribute("book") @Valid Book bookToUpdate, BindingResult result) {
        ModelAndView mv = new ModelAndView("redirect:/admin/books");

        if (result.hasErrors()) {
            mv.setViewName("admin/library/editbookinfo");
            mv.addObject("book", bookToUpdate);
            return mv;
        }

        bookService.saveBookRecord(bookToUpdate);
        return mv;
    }

}
