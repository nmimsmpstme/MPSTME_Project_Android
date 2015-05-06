.class public Lcom/delta/attendancetracker/EditCourse;
.super Landroid/app/Activity;
.source "EditCourse.java"


# instance fields
.field code:Landroid/widget/EditText;

.field datesMissed:Lorg/json/JSONArray;

.field details:Lorg/json/JSONObject;

.field edit:Landroid/widget/Button;

.field lab:Landroid/widget/RadioButton;

.field name:Landroid/widget/EditText;

.field required:Landroid/widget/EditText;

.field rg:Landroid/widget/RadioGroup;

.field theory:Landroid/widget/RadioButton;

.field total:Landroid/widget/EditText;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 17
    invoke-direct {p0}, Landroid/app/Activity;-><init>()V

    return-void
.end method


# virtual methods
.method public editCourse(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Lorg/json/JSONArray;)V
    .locals 12
    .parameter "name"
    .parameter "id"
    .parameter "total"
    .parameter "required"
    .parameter "radioButtonID"
    .parameter "courseName"
    .parameter "datesMissed"

    .prologue
    .line 130
    new-instance v1, Lorg/json/JSONObject;

    invoke-direct {v1}, Lorg/json/JSONObject;-><init>()V

    .line 131
    .local v1, course:Lorg/json/JSONObject;
    new-instance v8, Ljava/lang/String;

    invoke-direct {v8}, Ljava/lang/String;-><init>()V

    .line 132
    .local v8, type:Ljava/lang/String;
    sget-object v9, Ljava/lang/System;->out:Ljava/io/PrintStream;

    new-instance v10, Ljava/lang/StringBuilder;

    const-string v11, "In Button Click"

    invoke-direct {v10, v11}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, p6

    invoke-virtual {v10, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v9, v10}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    .line 134
    const v9, 0x7f080006

    move/from16 v0, p5

    if-ne v0, v9, :cond_1

    const-string v8, "theory"

    .line 138
    :goto_0
    const-string v9, "Courses"

    invoke-static {p0, v9}, Lcom/delta/attendancetracker/Prefs;->getMyStringPref(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 140
    .local v2, courses:Ljava/lang/String;
    new-instance v3, Lorg/json/JSONArray;

    invoke-direct {v3}, Lorg/json/JSONArray;-><init>()V

    .line 141
    .local v3, courses_json:Lorg/json/JSONArray;
    new-instance v7, Lorg/json/JSONObject;

    invoke-direct {v7}, Lorg/json/JSONObject;-><init>()V

    .line 143
    .local v7, jo:Lorg/json/JSONObject;
    if-eqz v2, :cond_0

    .line 145
    :try_start_0
    new-instance v4, Lorg/json/JSONArray;

    invoke-direct {v4, v2}, Lorg/json/JSONArray;-><init>(Ljava/lang/String;)V
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 146
    .end local v3           #courses_json:Lorg/json/JSONArray;
    .local v4, courses_json:Lorg/json/JSONArray;
    const/4 v6, 0x0

    .local v6, i:I
    :goto_1
    :try_start_1
    invoke-virtual {v4}, Lorg/json/JSONArray;->length()I
    :try_end_1
    .catch Lorg/json/JSONException; {:try_start_1 .. :try_end_1} :catch_1

    move-result v9

    if-lt v6, v9, :cond_2

    move-object v3, v4

    .line 181
    .end local v4           #courses_json:Lorg/json/JSONArray;
    .end local v6           #i:I
    .restart local v3       #courses_json:Lorg/json/JSONArray;
    :cond_0
    :goto_2
    const-string v9, "Courses"

    invoke-virtual {v3}, Lorg/json/JSONArray;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-static {p0, v9, v10}, Lcom/delta/attendancetracker/Prefs;->setMyStringPref(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    .line 183
    sget-object v9, Ljava/lang/System;->out:Ljava/io/PrintStream;

    new-instance v10, Ljava/lang/StringBuilder;

    const-string v11, "Courses ::: "

    invoke-direct {v10, v11}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3}, Lorg/json/JSONArray;->toString()Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v9, v10}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    .line 185
    invoke-virtual {p0}, Lcom/delta/attendancetracker/EditCourse;->finish()V

    .line 187
    return-void

    .line 135
    .end local v2           #courses:Ljava/lang/String;
    .end local v3           #courses_json:Lorg/json/JSONArray;
    .end local v7           #jo:Lorg/json/JSONObject;
    :cond_1
    const-string v8, "lab"

    goto :goto_0

    .line 148
    .restart local v2       #courses:Ljava/lang/String;
    .restart local v4       #courses_json:Lorg/json/JSONArray;
    .restart local v6       #i:I
    .restart local v7       #jo:Lorg/json/JSONObject;
    :cond_2
    :try_start_2
    sget-object v9, Ljava/lang/System;->out:Ljava/io/PrintStream;

    invoke-virtual {v9, v6}, Ljava/io/PrintStream;->println(I)V

    .line 150
    invoke-virtual {v4, v6}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v9

    const-string v10, "name"

    invoke-virtual {v9, v10}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    move-object/from16 v0, p6

    invoke-virtual {v9, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_4

    .line 152
    sget-object v9, Ljava/lang/System;->out:Ljava/io/PrintStream;

    const-string v10, "Satisfied"

    invoke-virtual {v9, v10}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    .line 154
    invoke-virtual {v4, v6}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v9

    const-string v10, "name"

    invoke-virtual {v9, v10, p1}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 155
    invoke-virtual {v4, v6}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v9

    const-string v10, "id"

    invoke-virtual {v9, v10, p2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 156
    invoke-virtual {v4, v6}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v9

    const-string v10, "total"

    invoke-virtual {v9, v10, p3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 157
    invoke-virtual {v4, v6}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v9

    const-string v10, "required"

    move-object/from16 v0, p4

    invoke-virtual {v9, v10, v0}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 159
    invoke-virtual {v4, v6}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v9

    const-string v10, "datesMissed"

    move-object/from16 v0, p7

    invoke-virtual {v9, v10, v0}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 162
    const v9, 0x7f080006

    move/from16 v0, p5

    if-ne v0, v9, :cond_3

    const-string v8, "theory"

    .line 165
    :goto_3
    invoke-virtual {v4, v6}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v9

    const-string v10, "type"

    invoke-virtual {v9, v10, v8}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    move-object v3, v4

    .line 168
    .end local v4           #courses_json:Lorg/json/JSONArray;
    .restart local v3       #courses_json:Lorg/json/JSONArray;
    goto/16 :goto_2

    .line 163
    .end local v3           #courses_json:Lorg/json/JSONArray;
    .restart local v4       #courses_json:Lorg/json/JSONArray;
    :cond_3
    const-string v8, "lab"
    :try_end_2
    .catch Lorg/json/JSONException; {:try_start_2 .. :try_end_2} :catch_1

    goto :goto_3

    .line 146
    :cond_4
    add-int/lit8 v6, v6, 0x1

    goto/16 :goto_1

    .line 173
    .end local v4           #courses_json:Lorg/json/JSONArray;
    .end local v6           #i:I
    .restart local v3       #courses_json:Lorg/json/JSONArray;
    :catch_0
    move-exception v5

    .line 175
    .local v5, e:Lorg/json/JSONException;
    :goto_4
    invoke-virtual {v5}, Lorg/json/JSONException;->printStackTrace()V

    goto/16 :goto_2

    .line 173
    .end local v3           #courses_json:Lorg/json/JSONArray;
    .end local v5           #e:Lorg/json/JSONException;
    .restart local v4       #courses_json:Lorg/json/JSONArray;
    .restart local v6       #i:I
    :catch_1
    move-exception v5

    move-object v3, v4

    .end local v4           #courses_json:Lorg/json/JSONArray;
    .restart local v3       #courses_json:Lorg/json/JSONArray;
    goto :goto_4
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 6
    .parameter "savedInstanceState"

    .prologue
    .line 32
    invoke-super {p0, p1}, Landroid/app/Activity;->onCreate(Landroid/os/Bundle;)V

    .line 33
    const v3, 0x7f030002

    invoke-virtual {p0, v3}, Lcom/delta/attendancetracker/EditCourse;->setContentView(I)V

    .line 35
    new-instance v3, Lorg/json/JSONArray;

    invoke-direct {v3}, Lorg/json/JSONArray;-><init>()V

    iput-object v3, p0, Lcom/delta/attendancetracker/EditCourse;->datesMissed:Lorg/json/JSONArray;

    .line 37
    invoke-virtual {p0}, Lcom/delta/attendancetracker/EditCourse;->getIntent()Landroid/content/Intent;

    move-result-object v2

    .line 39
    .local v2, u:Landroid/content/Intent;
    const-string v3, "details"

    invoke-virtual {v2, v3}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 42
    .local v1, extras:Ljava/lang/String;
    :try_start_0
    new-instance v3, Lorg/json/JSONObject;

    invoke-direct {v3, v1}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    iput-object v3, p0, Lcom/delta/attendancetracker/EditCourse;->details:Lorg/json/JSONObject;

    .line 43
    iget-object v3, p0, Lcom/delta/attendancetracker/EditCourse;->details:Lorg/json/JSONObject;

    const-string v4, "datesMissed"

    invoke-virtual {v3, v4}, Lorg/json/JSONObject;->getJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v3

    iput-object v3, p0, Lcom/delta/attendancetracker/EditCourse;->datesMissed:Lorg/json/JSONArray;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 51
    :goto_0
    const/high16 v3, 0x7f08

    invoke-virtual {p0, v3}, Lcom/delta/attendancetracker/EditCourse;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/EditText;

    iput-object v3, p0, Lcom/delta/attendancetracker/EditCourse;->name:Landroid/widget/EditText;

    .line 52
    const v3, 0x7f080002

    invoke-virtual {p0, v3}, Lcom/delta/attendancetracker/EditCourse;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/EditText;

    iput-object v3, p0, Lcom/delta/attendancetracker/EditCourse;->code:Landroid/widget/EditText;

    .line 53
    const v3, 0x7f080003

    invoke-virtual {p0, v3}, Lcom/delta/attendancetracker/EditCourse;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/EditText;

    iput-object v3, p0, Lcom/delta/attendancetracker/EditCourse;->total:Landroid/widget/EditText;

    .line 54
    const v3, 0x7f080004

    invoke-virtual {p0, v3}, Lcom/delta/attendancetracker/EditCourse;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/EditText;

    iput-object v3, p0, Lcom/delta/attendancetracker/EditCourse;->required:Landroid/widget/EditText;

    .line 56
    const v3, 0x7f080005

    invoke-virtual {p0, v3}, Lcom/delta/attendancetracker/EditCourse;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/RadioGroup;

    iput-object v3, p0, Lcom/delta/attendancetracker/EditCourse;->rg:Landroid/widget/RadioGroup;

    .line 57
    const v3, 0x7f080006

    invoke-virtual {p0, v3}, Lcom/delta/attendancetracker/EditCourse;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/RadioButton;

    iput-object v3, p0, Lcom/delta/attendancetracker/EditCourse;->theory:Landroid/widget/RadioButton;

    .line 58
    const v3, 0x7f080007

    invoke-virtual {p0, v3}, Lcom/delta/attendancetracker/EditCourse;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/RadioButton;

    iput-object v3, p0, Lcom/delta/attendancetracker/EditCourse;->lab:Landroid/widget/RadioButton;

    .line 60
    const v3, 0x7f08001c

    invoke-virtual {p0, v3}, Lcom/delta/attendancetracker/EditCourse;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/Button;

    iput-object v3, p0, Lcom/delta/attendancetracker/EditCourse;->edit:Landroid/widget/Button;

    .line 61
    iget-object v3, p0, Lcom/delta/attendancetracker/EditCourse;->edit:Landroid/widget/Button;

    new-instance v4, Lcom/delta/attendancetracker/EditCourse$1;

    invoke-direct {v4, p0}, Lcom/delta/attendancetracker/EditCourse$1;-><init>(Lcom/delta/attendancetracker/EditCourse;)V

    invoke-virtual {v3, v4}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 113
    :try_start_1
    iget-object v3, p0, Lcom/delta/attendancetracker/EditCourse;->name:Landroid/widget/EditText;

    iget-object v4, p0, Lcom/delta/attendancetracker/EditCourse;->details:Lorg/json/JSONObject;

    const-string v5, "name"

    invoke-virtual {v4, v5}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 114
    iget-object v3, p0, Lcom/delta/attendancetracker/EditCourse;->code:Landroid/widget/EditText;

    iget-object v4, p0, Lcom/delta/attendancetracker/EditCourse;->details:Lorg/json/JSONObject;

    const-string v5, "id"

    invoke-virtual {v4, v5}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 115
    iget-object v3, p0, Lcom/delta/attendancetracker/EditCourse;->total:Landroid/widget/EditText;

    iget-object v4, p0, Lcom/delta/attendancetracker/EditCourse;->details:Lorg/json/JSONObject;

    const-string v5, "total"

    invoke-virtual {v4, v5}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 116
    iget-object v3, p0, Lcom/delta/attendancetracker/EditCourse;->required:Landroid/widget/EditText;

    iget-object v4, p0, Lcom/delta/attendancetracker/EditCourse;->details:Lorg/json/JSONObject;

    const-string v5, "required"

    invoke-virtual {v4, v5}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 117
    iget-object v3, p0, Lcom/delta/attendancetracker/EditCourse;->details:Lorg/json/JSONObject;

    const-string v4, "type"

    invoke-virtual {v3, v4}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    const-string v4, "theory"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_0

    iget-object v3, p0, Lcom/delta/attendancetracker/EditCourse;->theory:Landroid/widget/RadioButton;

    const/4 v4, 0x1

    invoke-virtual {v3, v4}, Landroid/widget/RadioButton;->setSelected(Z)V
    :try_end_1
    .catch Lorg/json/JSONException; {:try_start_1 .. :try_end_1} :catch_1

    .line 126
    :goto_1
    return-void

    .line 44
    :catch_0
    move-exception v0

    .line 46
    .local v0, e:Lorg/json/JSONException;
    invoke-virtual {v0}, Lorg/json/JSONException;->printStackTrace()V

    goto/16 :goto_0

    .line 118
    .end local v0           #e:Lorg/json/JSONException;
    :cond_0
    :try_start_2
    iget-object v3, p0, Lcom/delta/attendancetracker/EditCourse;->lab:Landroid/widget/RadioButton;

    const/4 v4, 0x1

    invoke-virtual {v3, v4}, Landroid/widget/RadioButton;->setSelected(Z)V
    :try_end_2
    .catch Lorg/json/JSONException; {:try_start_2 .. :try_end_2} :catch_1

    goto :goto_1

    .line 120
    :catch_1
    move-exception v0

    .line 122
    .restart local v0       #e:Lorg/json/JSONException;
    invoke-virtual {v0}, Lorg/json/JSONException;->printStackTrace()V

    goto :goto_1
.end method
