/*
 * Copyright (c) 2017. Ruslan Primak
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
 * Last modified 7/19/17 2:41 PM
 */

package link.primak.databindingobservable;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.text.TextUtils;
import android.view.View;

import org.jetbrains.annotations.NotNull;

import java.util.Random;

public class CustomTextEdit extends BaseObservable{
    private String text;
    private static final Random rnd = new Random();

    public CustomTextEdit(@NotNull String text) {
        this.text = text;
    }

    @Bindable
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
        notifyPropertyChanged(link.primak.databindingobservable.BR.text);
    }

    public void onAddChar(View view) {
        setText(text + rndChar());
    }

    public void onDelChar(View view) {
        if (!TextUtils.isEmpty(text)) {
            setText(text.substring(0, text.length()-1));
        }
    }

    public void onClear(View view) {
        setText("");
    }

    private static char rndChar () {
        int index = rnd.nextInt(52);
        char base = (index < 26) ? 'A' : 'a';
        return (char) (base + index % 26);
    }
}
