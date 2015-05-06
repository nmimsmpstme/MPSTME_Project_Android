.class public Lcom/delta/attendancetracker/AddCourse;
.super Landroid/app/Activity;
.source "AddCourse.java"


# instance fields
.field add:Landroid/widget/Button;

.field courseCode:Landroid/widget/EditText;

.field courseName:Landroid/widget/EditText;

.field percentRequired:Landroid/widget/EditText;

.field radioButtonGroup:Landroid/widget/RadioGroup;

.field totalClasses:Landroid/widget/EditText;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 15
    invoke-direct {p0}, Landroid/app/Activity;-><init>()V

    return-void
.end method


# virtual methods
.method protected onCreate(Landroid/os/Bundle;)V
    .locals 2
    .parameter "savedInstanceState"

    .prologue
    .line 25
    invoke-super {p0, p1}, Landroid/app/Activity;->onCreate(Landroid/os/Bundle;)V

    .line 26
    const/high16 v0, 0x7f03

    invoke-virtual {p0, v0}, Lcom/delta/attendancetracker/AddCourse;->setContentView(I)V

    .line 28
    const v0, 0x7f080008

    invoke-virtual {p0, v0}, Lcom/delta/attendancetracker/AddCourse;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    iput-object v0, p0, Lcom/delta/attendancetracker/AddCourse;->add:Landroid/widget/Button;

    .line 29
    const/high16 v0, 0x7f08

    invoke-virtual {p0, v0}, Lcom/delta/attendancetracker/AddCourse;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/EditText;

    iput-object v0, p0, Lcom/delta/attendancetracker/AddCourse;->courseName:Landroid/widget/EditText;

    .line 30
    const v0, 0x7f080002

    invoke-virtual {p0, v0}, Lcom/delta/attendancetracker/AddCourse;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/EditText;

    iput-object v0, p0, Lcom/delta/attendancetracker/AddCourse;->courseCode:Landroid/widget/EditText;

    .line 31
    const v0, 0x7f080003

    invoke-virtual {p0, v0}, Lcom/delta/attendancetracker/AddCourse;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/EditText;

    iput-object v0, p0, Lcom/delta/attendancetracker/AddCourse;->totalClasses:Landroid/widget/EditText;

    .line 32
    const v0, 0x7f080004

    invoke-virtual {p0, v0}, Lcom/delta/attendancetracker/AddCourse;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/EditText;

    iput-object v0, p0, Lcom/delta/attendancetracker/AddCourse;->percentRequired:Landroid/widget/EditText;

    .line 33
    const v0, 0x7f080005

    invoke-virtual {p0, v0}, Lcom/delta/attendancetracker/AddCourse;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RadioGroup;

    iput-object v0, p0, Lcom/delta/attendancetracker/AddCourse;->radioButtonGroup:Landroid/widget/RadioGroup;

    .line 37
    iget-object v0, p0, Lcom/delta/attendancetracker/AddCourse;->add:Landroid/widget/Button;

    new-instance v1, Lcom/delta/attendancetracker/AddCourse$1;

    invoke-direct {v1, p0}, Lcom/delta/attendancetracker/AddCourse$1;-><init>(Lcom/delta/attendancetracker/AddCourse;)V

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 65
    return-void
.end method

.method public storeCourse(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V
    .locals 12
    .parameter "name"
    .parameter "id"
    .parameter "total"
    .parameter "required"
    .parameter "radioButtonID"

    .prologue
    .line 69
    new-instance v1, Lorg/json/JSONObject;

    invoke-direct {v1}, Lorg/json/JSONObject;-><init>()V

    .line 70
    .local v1, course:Lorg/json/JSONObject;
    new-instance v8, Ljava/lang/String;

    invoke-direct {v8}, Ljava/lang/String;-><init>()V

    .line 71
    .local v8, type:Ljava/lang/String;
    sget-object v9, Ljava/lang/System;->out:Ljava/io/PrintStream;

    const-string v10, "In Button Click"

    invoke-virtual {v9, v10}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    .line 74
    :try_start_0
    sget-object v9, Ljava/lang/System;->out:Ljava/io/PrintStream;

    const-string v10, "In Try"

    invoke-virtual {v9, v10}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    .line 75
    const-string v9, "name"

    invoke-virtual {v1, v9, p1}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 76
    const-string v9, "id"

    invoke-virtual {v1, v9, p2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 77
    const-string v9, "total"

    invoke-virtual {v1, v9, p3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 78
    const-string v9, "required"

    move-object/from16 v0, p4

    invoke-virtual {v1, v9, v0}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 79
    const-string v9, "classesHeld"

    const-string v10, "0"

    invoke-virtual {v1, v9, v10}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 80
    const-string v9, "classesMissed"

    const-string v10, "0"

    invoke-virtual {v1, v9, v10}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 82
    new-instance v5, Lorg/json/JSONArray;

    invoke-direct {v5}, Lorg/json/JSONArray;-><init>()V

    .line 83
    .local v5, datesMissed:Lorg/json/JSONArray;
    const-string v9, "datesMissed"

    invoke-virtual {v1, v9, v5}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 85
    const v9, 0x7f080006

    move/from16 v0, p5

    if-ne v0, v9, :cond_1

    const-string v8, "theory"

    .line 88
    :goto_0
    const-string v9, "type"

    invoke-virtual {v1, v9, v8}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 96
    .end local v5           #datesMissed:Lorg/json/JSONArray;
    :goto_1
    :try_start_1
    sget-object v9, Ljava/lang/System;->out:Ljava/io/PrintStream;

    new-instance v10, Ljava/lang/StringBuilder;

    const-string v11, "Course :::::::: "

    invoke-direct {v10, v11}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v11, "name"

    invoke-virtual {v1, v11}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v9, v10}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V
    :try_end_1
    .catch Lorg/json/JSONException; {:try_start_1 .. :try_end_1} :catch_1

    .line 102
    :goto_2
    new-instance v9, Ljava/lang/StringBuilder;

    invoke-static {p1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v10

    invoke-direct {v9, v10}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v9, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    .line 104
    .local v7, key:Ljava/lang/String;
    const-string v9, "Courses"

    invoke-static {p0, v9}, Lcom/delta/attendancetracker/Prefs;->getMyStringPref(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 106
    .local v2, courses:Ljava/lang/String;
    new-instance v3, Lorg/json/JSONArray;

    invoke-direct {v3}, Lorg/json/JSONArray;-><init>()V

    .line 108
    .local v3, courses_json:Lorg/json/JSONArray;
    if-eqz v2, :cond_0

    .line 110
    :try_start_2
    new-instance v4, Lorg/json/JSONArray;

    invoke-direct {v4, v2}, Lorg/json/JSONArray;-><init>(Ljava/lang/String;)V
    :try_end_2
    .catch Lorg/json/JSONException; {:try_start_2 .. :try_end_2} :catch_2

    .end local v3           #courses_json:Lorg/json/JSONArray;
    .local v4, courses_json:Lorg/json/JSONArray;
    move-object v3, v4

    .line 117
    .end local v4           #courses_json:Lorg/json/JSONArray;
    .restart local v3       #courses_json:Lorg/json/JSONArray;
    :cond_0
    :goto_3
    invoke-virtual {v3, v1}, Lorg/json/JSONArray;->put(Ljava/lang/Object;)Lorg/json/JSONArray;

    .line 119
    const-string v9, "Courses"

    invoke-virtual {v3}, Lorg/json/JSONArray;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-static {p0, v9, v10}, Lcom/delta/attendancetracker/Prefs;->setMyStringPref(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    .line 121
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

    .line 123
    invoke-virtual {p0}, Lcom/delta/attendancetracker/AddCourse;->finish()V

    .line 125
    return-void

    .line 86
    .end local v2           #courses:Ljava/lang/String;
    .end local v3           #courses_json:Lorg/json/JSONArray;
    .end local v7           #key:Ljava/lang/String;
    .restart local v5       #datesMissed:Lorg/json/JSONArray;
    :cond_1
    :try_start_3
    const-string v8, "lab"
    :try_end_3
    .catch Lorg/json/JSONException; {:try_start_3 .. :try_end_3} :catch_0

    goto :goto_0

    .line 90
    .end local v5           #datesMissed:Lorg/json/JSONArray;
    :catch_0
    move-exception v6

    .line 92
    .local v6, e:Lorg/json/JSONException;
    invoke-virtual {v6}, Lorg/json/JSONException;->printStackTrace()V

    goto :goto_1

    .line 97
    .end local v6           #e:Lorg/json/JSONException;
    :catch_1
    move-exception v6

    .line 99
    .restart local v6       #e:Lorg/json/JSONException;
    invoke-virtual {v6}, Lorg/json/JSONException;->printStackTrace()V

    goto :goto_2

    .line 111
    .end local v6           #e:Lorg/json/JSONException;
    .restart local v2       #courses:Ljava/lang/String;
    .restart local v3       #courses_json:Lorg/json/JSONArray;
    .restart local v7       #key:Ljava/lang/String;
    :catch_2
    move-exception v6

    .line 113
    .restart local v6       #e:Lorg/json/JSONException;
    invoke-virtual {v6}, Lorg/json/JSONException;->printStackTrace()V

    goto :goto_3
.end method
