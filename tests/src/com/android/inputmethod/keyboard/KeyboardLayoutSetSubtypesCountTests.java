/*
 * Copyright (C) 2014 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.inputmethod.keyboard;

import android.test.suitebuilder.annotation.SmallTest;
import android.view.inputmethod.InputMethodSubtype;

import com.android.inputmethod.latin.utils.SubtypeLocaleUtils;

import java.util.ArrayList;

@SmallTest
public class KeyboardLayoutSetSubtypesCountTests extends KeyboardLayoutSetTestsBase {
    private static final int NUMBER_OF_SUBTYPES = 63;
    private static final int NUMBER_OF_ASCII_CAPABLE_SUBTYPES = 42;
    private static final int NUMBER_OF_PREDEFINED_ADDITIONAL_SUBTYPES = 2;

    private static String toString(final ArrayList<InputMethodSubtype> subtypeList) {
        final StringBuilder sb = new StringBuilder();
        for (int index = 0; index < subtypeList.size(); index++) {
            final InputMethodSubtype subtype = subtypeList.get(index);
            sb.append(index + ": ");
            sb.append(SubtypeLocaleUtils.getSubtypeNameForLogging(subtype));
            sb.append("\n");
        }
        return sb.toString();
    }

    public final void testAllSubtypesCount() {
        final ArrayList<InputMethodSubtype> allSubtypesList = getAllSubtypesList();
        assertEquals(toString(allSubtypesList), NUMBER_OF_SUBTYPES, allSubtypesList.size());
    }

    public final void testAsciiCapableSubtypesCount() {
        final ArrayList<InputMethodSubtype> asciiCapableSubtypesList =
                getAsciiCapableSubtypesList();
        assertEquals(toString(asciiCapableSubtypesList),
                NUMBER_OF_ASCII_CAPABLE_SUBTYPES, asciiCapableSubtypesList.size());
    }

    public final void testAdditionalSubtypesCount() {
        final ArrayList<InputMethodSubtype> additionalSubtypesList = getAdditionalSubtypesList();
        assertEquals(toString(additionalSubtypesList),
                NUMBER_OF_PREDEFINED_ADDITIONAL_SUBTYPES, additionalSubtypesList.size());
    }
}
