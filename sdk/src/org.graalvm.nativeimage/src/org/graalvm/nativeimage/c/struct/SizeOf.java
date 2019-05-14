/*
 * Copyright (c) 2013, 2018, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * The Universal Permissive License (UPL), Version 1.0
 *
 * Subject to the condition set forth below, permission is hereby granted to any
 * person obtaining a copy of this software, associated documentation and/or
 * data (collectively the "Software"), free of charge and under any and all
 * copyright rights in the Software, and any and all patent rights owned or
 * freely licensable by each licensor hereunder covering either (i) the
 * unmodified Software as contributed to or provided by such licensor, or (ii)
 * the Larger Works (as defined below), to deal in both
 *
 * (a) the Software, and
 *
 * (b) any piece of software and/or hardware listed in the lrgrwrks.txt file if
 * one is included with the Software each a "Larger Work" to which the Software
 * is contributed by such licensors),
 *
 * without restriction, including without limitation the rights to copy, create
 * derivative works of, display, perform, and distribute the Software and make,
 * use, sell, offer for sale, import, export, have made, and have sold the
 * Software and the Larger Work(s), and to sublicense the foregoing rights on
 * either these or other terms.
 *
 * This license is subject to the following condition:
 *
 * The above copyright notice and either this complete permission notice or at a
 * minimum a reference to the UPL must be included in all copies or substantial
 * portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package org.graalvm.nativeimage.c.struct;

import org.graalvm.nativeimage.ImageSingletons;
import org.graalvm.nativeimage.impl.SizeOfSupport;
import org.graalvm.word.PointerBase;
import org.graalvm.word.UnsignedWord;
import org.graalvm.word.WordFactory;

/**
 * Contains static methods that provide access to the size of <b>dereferenced</b> SystemJava pointer
 * types (i.e. the size of the data structure pointed-to by SystemJava pointer). Note that this
 * semantic differs from the sizeof-operator defined by the C programming language.
 *
 * @since 19.0
 */
public final class SizeOf {

    private SizeOf() {
    }

    /**
     * Returns the size of the data structure pointed to by SystemJava pointer types. The class must
     * be annotated with {@link CStruct}, {@link CPointerTo}, or {@link RawStructure}.
     *
     * @since 19.0
     */
    public static int get(Class<? extends PointerBase> clazz) {
        return ImageSingletons.lookup(SizeOfSupport.class).sizeof(clazz);
    }

    /**
     * Returns the {@link #get size} cast to {@link UnsignedWord}.
     *
     * @since 19.0
     */
    public static UnsignedWord unsigned(Class<? extends PointerBase> clazz) {
        return WordFactory.unsigned(get(clazz));
    }
}
