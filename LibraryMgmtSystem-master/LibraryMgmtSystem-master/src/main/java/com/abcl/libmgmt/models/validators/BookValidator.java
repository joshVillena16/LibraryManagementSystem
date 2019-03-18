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
package com.abcl.libmgmt.models.validators;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.abcl.libmgmt.models.Book;

/**
 * TODO: Add validation on persistence layer instead of in controllers only
 */
@Component
@Qualifier("bookValidator")
public class BookValidator implements Validator {

    /*
     * (non-Javadoc)
     *
     * @see org.springframework.validation.Validator#supports(java.lang.Class)
     */
    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.isAssignableFrom(Book.class);
    }

    /*
     * (non-Javadoc)
     *
     * @see org.springframework.validation.Validator#validate(java.lang.Object, org.springframework.validation.Errors)
     */
    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "bookTitle", "msg.field.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "isbin", "msg.field.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "publishDate", "msg.field.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "authors", "msg.field.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "stock", "msg.field.required");
    }

}
