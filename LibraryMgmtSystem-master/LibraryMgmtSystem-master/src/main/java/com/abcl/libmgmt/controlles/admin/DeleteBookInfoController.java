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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.abcl.libmgmt.service.IBookService;

/**
 *
 */
@Controller
public class DeleteBookInfoController {

    @Autowired
    IBookService bookService;

    @DeleteMapping("/admin/library/deletebook/{isbin}")
    public ModelAndView deleteBookInfoDelete(@PathVariable("isbin") String isbinNo) {
        ModelAndView mv = new ModelAndView("redirect:/admin/books");
        bookService.deleteBookByIsbin(isbinNo);
        return mv;
    }

    /**
     * Justification for this method is at
     * https://softwareengineering.stackexchange.com/questions/114156/why-are-there-are-no-put-and-delete-methods-on-html-forms
     *
     * Since HTML5 delete on form is no longer supported
     *
     * @param isbinNo
     * @return
     */
    @PostMapping("/admin/library/deletebook/{isbin}")
    public ModelAndView deleteBookInfoPost(@PathVariable("isbin") String isbinNo) {
        ModelAndView mv = new ModelAndView("redirect:/admin/booksajax");
        bookService.deleteBookByIsbin(isbinNo);
        return mv;
    }

}
