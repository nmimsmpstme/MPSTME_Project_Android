.class public Lcom/delta/attendancetracker/CourseAttendance;
.super Landroid/support/v4/app/FragmentActivity;
.source "CourseAttendance.java"

# interfaces
.implements Landroid/app/DatePickerDialog$OnDateSetListener;


# annotations
.annotation build Landroid/annotation/SuppressLint;
    value = {
        "NewApi"
    }
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/delta/attendancetracker/CourseAttendance$StableArrayAdapter;
    }
.end annotation


# instance fields
.field adapter:Lcom/delta/attendancetracker/CourseAttendance$StableArrayAdapter;

.field attendance:Landroid/widget/TextView;

.field classesmissed:Landroid/widget/ListView;

.field courseName:Ljava/lang/String;

.field currentdate1:Ljava/lang/StringBuilder;

.field dd:I

.field estimated:Landroid/widget/TextView;

.field extra:Lorg/json/JSONObject;

.field extras:Ljava/lang/String;

.field heldminus:Landroid/widget/Button;

.field heldplus:Landroid/widget/Button;

.field private listPosition:I

.field missedlist:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field missedminus:Landroid/widget/Button;

.field missedplus:Landroid/widget/Button;

.field mm:I

.field nClassesHeld:Landroid/widget/TextView;

.field nClassesMissed:Landroid/widget/TextView;

.field position:I

.field reqd:Landroid/widget/TextView;

.field yy:I


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 31
    invoke-direct {p0}, Landroid/support/v4/app/FragmentActivity;-><init>()V

    .line 33
    const/4 v0, -0x1

    iput v0, p0, Lcom/delta/attendancetracker/CourseAttendance;->listPosition:I

    .line 41
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    iput-object v0, p0, Lcom/delta/attendancetracker/CourseAttendance;->currentdate1:Ljava/lang/StringBuilder;

    .line 45
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/delta/attendancetracker/CourseAttendance;->missedlist:Ljava/util/ArrayList;

    .line 31
    return-void
.end method

.method static synthetic access$0(Lcom/delta/attendancetracker/CourseAttendance;I)V
    .locals 0
    .parameter
    .parameter

    .prologue
    .line 33
    iput p1, p0, Lcom/delta/attendancetracker/CourseAttendance;->listPosition:I

    return-void
.end method


# virtual methods
.method protected onCreate(Landroid/os/Bundle;)V
    .locals 7
    .parameter "savedInstanceState"

    .prologue
    .line 54
    invoke-super {p0, p1}, Landroid/support/v4/app/FragmentActivity;->onCreate(Landroid/os/Bundle;)V

    .line 55
    const v4, 0x7f030001

    invoke-virtual {p0, v4}, Lcom/delta/attendancetracker/CourseAttendance;->setContentView(I)V

    .line 58
    invoke-virtual {p0}, Lcom/delta/attendancetracker/CourseAttendance;->getIntent()Landroid/content/Intent;

    move-result-object v3

    .line 60
    .local v3, u:Landroid/content/Intent;
    const-string v4, "details"

    invoke-virtual {v3, v4}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    iput-object v4, p0, Lcom/delta/attendancetracker/CourseAttendance;->extras:Ljava/lang/String;

    .line 61
    const-string v4, "position"

    const/4 v5, -0x1

    invoke-virtual {v3, v4, v5}, Landroid/content/Intent;->getIntExtra(Ljava/lang/String;I)I

    move-result v4

    iput v4, p0, Lcom/delta/attendancetracker/CourseAttendance;->position:I

    .line 62
    new-instance v2, Lorg/json/JSONArray;

    invoke-direct {v2}, Lorg/json/JSONArray;-><init>()V

    .line 64
    .local v2, ja:Lorg/json/JSONArray;
    const v4, 0x7f08001b

    invoke-virtual {p0, v4}, Lcom/delta/attendancetracker/CourseAttendance;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/ListView;

    iput-object v4, p0, Lcom/delta/attendancetracker/CourseAttendance;->classesmissed:Landroid/widget/ListView;

    .line 65
    const v4, 0x7f08000b

    invoke-virtual {p0, v4}, Lcom/delta/attendancetracker/CourseAttendance;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/TextView;

    iput-object v4, p0, Lcom/delta/attendancetracker/CourseAttendance;->nClassesHeld:Landroid/widget/TextView;

    .line 66
    const v4, 0x7f080011

    invoke-virtual {p0, v4}, Lcom/delta/attendancetracker/CourseAttendance;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/TextView;

    iput-object v4, p0, Lcom/delta/attendancetracker/CourseAttendance;->nClassesMissed:Landroid/widget/TextView;

    .line 68
    const v4, 0x7f080016

    invoke-virtual {p0, v4}, Lcom/delta/attendancetracker/CourseAttendance;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/TextView;

    iput-object v4, p0, Lcom/delta/attendancetracker/CourseAttendance;->reqd:Landroid/widget/TextView;

    .line 69
    const v4, 0x7f080017

    invoke-virtual {p0, v4}, Lcom/delta/attendancetracker/CourseAttendance;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/TextView;

    iput-object v4, p0, Lcom/delta/attendancetracker/CourseAttendance;->attendance:Landroid/widget/TextView;

    .line 70
    const v4, 0x7f08001a

    invoke-virtual {p0, v4}, Lcom/delta/attendancetracker/CourseAttendance;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/TextView;

    iput-object v4, p0, Lcom/delta/attendancetracker/CourseAttendance;->estimated:Landroid/widget/TextView;

    .line 72
    const v4, 0x7f08000e

    invoke-virtual {p0, v4}, Lcom/delta/attendancetracker/CourseAttendance;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/Button;

    iput-object v4, p0, Lcom/delta/attendancetracker/CourseAttendance;->heldplus:Landroid/widget/Button;

    .line 73
    const v4, 0x7f08000d

    invoke-virtual {p0, v4}, Lcom/delta/attendancetracker/CourseAttendance;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/Button;

    iput-object v4, p0, Lcom/delta/attendancetracker/CourseAttendance;->heldminus:Landroid/widget/Button;

    .line 74
    const v4, 0x7f080014

    invoke-virtual {p0, v4}, Lcom/delta/attendancetracker/CourseAttendance;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/Button;

    iput-object v4, p0, Lcom/delta/attendancetracker/CourseAttendance;->missedplus:Landroid/widget/Button;

    .line 75
    const v4, 0x7f080013

    invoke-virtual {p0, v4}, Lcom/delta/attendancetracker/CourseAttendance;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/Button;

    iput-object v4, p0, Lcom/delta/attendancetracker/CourseAttendance;->missedminus:Landroid/widget/Button;

    .line 77
    new-instance v4, Ljava/util/ArrayList;

    invoke-direct {v4}, Ljava/util/ArrayList;-><init>()V

    iput-object v4, p0, Lcom/delta/attendancetracker/CourseAttendance;->missedlist:Ljava/util/ArrayList;

    .line 82
    :try_start_0
    new-instance v4, Lorg/json/JSONObject;

    iget-object v5, p0, Lcom/delta/attendancetracker/CourseAttendance;->extras:Ljava/lang/String;

    invoke-direct {v4, v5}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    iput-object v4, p0, Lcom/delta/attendancetracker/CourseAttendance;->extra:Lorg/json/JSONObject;

    .line 83
    iget-object v4, p0, Lcom/delta/attendancetracker/CourseAttendance;->nClassesHeld:Landroid/widget/TextView;

    iget-object v5, p0, Lcom/delta/attendancetracker/CourseAttendance;->extra:Lorg/json/JSONObject;

    const-string v6, "classesHeld"

    invoke-virtual {v5, v6}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 84
    iget-object v4, p0, Lcom/delta/attendancetracker/CourseAttendance;->nClassesMissed:Landroid/widget/TextView;

    iget-object v5, p0, Lcom/delta/attendancetracker/CourseAttendance;->extra:Lorg/json/JSONObject;

    const-string v6, "classesMissed"

    invoke-virtual {v5, v6}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 85
    iget-object v4, p0, Lcom/delta/attendancetracker/CourseAttendance;->reqd:Landroid/widget/TextView;

    iget-object v5, p0, Lcom/delta/attendancetracker/CourseAttendance;->extra:Lorg/json/JSONObject;

    const-string v6, "required"

    invoke-virtual {v5, v6}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 86
    iget-object v4, p0, Lcom/delta/attendancetracker/CourseAttendance;->extra:Lorg/json/JSONObject;

    const-string v5, "name"

    invoke-virtual {v4, v5}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    iput-object v4, p0, Lcom/delta/attendancetracker/CourseAttendance;->courseName:Ljava/lang/String;

    .line 87
    invoke-virtual {p0}, Lcom/delta/attendancetracker/CourseAttendance;->getActionBar()Landroid/app/ActionBar;

    move-result-object v4

    iget-object v5, p0, Lcom/delta/attendancetracker/CourseAttendance;->courseName:Ljava/lang/String;

    invoke-virtual {v4, v5}, Landroid/app/ActionBar;->setTitle(Ljava/lang/CharSequence;)V

    .line 89
    iget-object v4, p0, Lcom/delta/attendancetracker/CourseAttendance;->extra:Lorg/json/JSONObject;

    const-string v5, "datesMissed"

    invoke-virtual {v4, v5}, Lorg/json/JSONObject;->getJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v2

    .line 95
    :goto_0
    const/4 v1, 0x0

    .local v1, j:I
    :goto_1
    invoke-virtual {v2}, Lorg/json/JSONArray;->length()I

    move-result v4

    if-lt v1, v4, :cond_0

    .line 103
    new-instance v4, Lcom/delta/attendancetracker/CourseAttendance$StableArrayAdapter;

    .line 104
    const v5, 0x1090003

    iget-object v6, p0, Lcom/delta/attendancetracker/CourseAttendance;->missedlist:Ljava/util/ArrayList;

    invoke-direct {v4, p0, p0, v5, v6}, Lcom/delta/attendancetracker/CourseAttendance$StableArrayAdapter;-><init>(Lcom/delta/attendancetracker/CourseAttendance;Landroid/content/Context;ILjava/util/List;)V

    .line 103
    iput-object v4, p0, Lcom/delta/attendancetracker/CourseAttendance;->adapter:Lcom/delta/attendancetracker/CourseAttendance$StableArrayAdapter;

    .line 106
    iget-object v4, p0, Lcom/delta/attendancetracker/CourseAttendance;->classesmissed:Landroid/widget/ListView;

    iget-object v5, p0, Lcom/delta/attendancetracker/CourseAttendance;->adapter:Lcom/delta/attendancetracker/CourseAttendance$StableArrayAdapter;

    invoke-virtual {v4, v5}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 108
    iget-object v4, p0, Lcom/delta/attendancetracker/CourseAttendance;->classesmissed:Landroid/widget/ListView;

    new-instance v5, Lcom/delta/attendancetracker/CourseAttendance$1;

    invoke-direct {v5, p0}, Lcom/delta/attendancetracker/CourseAttendance$1;-><init>(Lcom/delta/attendancetracker/CourseAttendance;)V

    invoke-virtual {v4, v5}, Landroid/widget/ListView;->setOnItemClickListener(Landroid/widget/AdapterView$OnItemClickListener;)V

    .line 139
    iget-object v4, p0, Lcom/delta/attendancetracker/CourseAttendance;->heldplus:Landroid/widget/Button;

    new-instance v5, Lcom/delta/attendancetracker/CourseAttendance$2;

    invoke-direct {v5, p0}, Lcom/delta/attendancetracker/CourseAttendance$2;-><init>(Lcom/delta/attendancetracker/CourseAttendance;)V

    invoke-virtual {v4, v5}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 166
    iget-object v4, p0, Lcom/delta/attendancetracker/CourseAttendance;->heldminus:Landroid/widget/Button;

    new-instance v5, Lcom/delta/attendancetracker/CourseAttendance$3;

    invoke-direct {v5, p0}, Lcom/delta/attendancetracker/CourseAttendance$3;-><init>(Lcom/delta/attendancetracker/CourseAttendance;)V

    invoke-virtual {v4, v5}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 184
    iget-object v4, p0, Lcom/delta/attendancetracker/CourseAttendance;->missedplus:Landroid/widget/Button;

    new-instance v5, Lcom/delta/attendancetracker/CourseAttendance$4;

    invoke-direct {v5, p0}, Lcom/delta/attendancetracker/CourseAttendance$4;-><init>(Lcom/delta/attendancetracker/CourseAttendance;)V

    invoke-virtual {v4, v5}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 233
    iget-object v4, p0, Lcom/delta/attendancetracker/CourseAttendance;->missedminus:Landroid/widget/Button;

    new-instance v5, Lcom/delta/attendancetracker/CourseAttendance$5;

    invoke-direct {v5, p0}, Lcom/delta/attendancetracker/CourseAttendance$5;-><init>(Lcom/delta/attendancetracker/CourseAttendance;)V

    invoke-virtual {v4, v5}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 282
    return-void

    .line 91
    .end local v1           #j:I
    :catch_0
    move-exception v0

    .line 93
    .local v0, e:Lorg/json/JSONException;
    invoke-virtual {v0}, Lorg/json/JSONException;->printStackTrace()V

    goto :goto_0

    .line 97
    .end local v0           #e:Lorg/json/JSONException;
    .restart local v1       #j:I
    :cond_0
    :try_start_1
    iget-object v4, p0, Lcom/delta/attendancetracker/CourseAttendance;->missedlist:Ljava/util/ArrayList;

    invoke-virtual {v2, v1}, Lorg/json/JSONArray;->getString(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z
    :try_end_1
    .catch Lorg/json/JSONException; {:try_start_1 .. :try_end_1} :catch_1

    .line 95
    :goto_2
    add-int/lit8 v1, v1, 0x1

    goto :goto_1

    .line 98
    :catch_1
    move-exception v0

    .line 100
    .restart local v0       #e:Lorg/json/JSONException;
    invoke-virtual {v0}, Lorg/json/JSONException;->printStackTrace()V

    goto :goto_2
.end method

.method public onCreateOptionsMenu(Landroid/view/Menu;)Z
    .locals 2
    .parameter "menu"

    .prologue
    .line 462
    invoke-virtual {p0}, Lcom/delta/attendancetracker/CourseAttendance;->getMenuInflater()Landroid/view/MenuInflater;

    move-result-object v0

    const v1, 0x7f070002

    invoke-virtual {v0, v1, p1}, Landroid/view/MenuInflater;->inflate(ILandroid/view/Menu;)V

    .line 463
    const/4 v0, 0x1

    return v0
.end method

.method public onDateSet(Landroid/widget/DatePicker;III)V
    .locals 3
    .parameter "view"
    .parameter "year"
    .parameter "month"
    .parameter "day"

    .prologue
    .line 439
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0, p4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "/"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    add-int/lit8 v1, p3, 0x1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "/"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    iput-object v0, p0, Lcom/delta/attendancetracker/CourseAttendance;->currentdate1:Ljava/lang/StringBuilder;

    .line 440
    iget-object v0, p0, Lcom/delta/attendancetracker/CourseAttendance;->missedlist:Ljava/util/ArrayList;

    iget v1, p0, Lcom/delta/attendancetracker/CourseAttendance;->listPosition:I

    iget-object v2, p0, Lcom/delta/attendancetracker/CourseAttendance;->currentdate1:Ljava/lang/StringBuilder;

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/util/ArrayList;->set(ILjava/lang/Object;)Ljava/lang/Object;

    .line 441
    new-instance v0, Lcom/delta/attendancetracker/CourseAttendance$StableArrayAdapter;

    .line 442
    const v1, 0x1090003

    iget-object v2, p0, Lcom/delta/attendancetracker/CourseAttendance;->missedlist:Ljava/util/ArrayList;

    invoke-direct {v0, p0, p0, v1, v2}, Lcom/delta/attendancetracker/CourseAttendance$StableArrayAdapter;-><init>(Lcom/delta/attendancetracker/CourseAttendance;Landroid/content/Context;ILjava/util/List;)V

    .line 441
    iput-object v0, p0, Lcom/delta/attendancetracker/CourseAttendance;->adapter:Lcom/delta/attendancetracker/CourseAttendance$StableArrayAdapter;

    .line 444
    iget-object v0, p0, Lcom/delta/attendancetracker/CourseAttendance;->classesmissed:Landroid/widget/ListView;

    iget-object v1, p0, Lcom/delta/attendancetracker/CourseAttendance;->adapter:Lcom/delta/attendancetracker/CourseAttendance$StableArrayAdapter;

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 446
    iget-object v0, p0, Lcom/delta/attendancetracker/CourseAttendance;->classesmissed:Landroid/widget/ListView;

    new-instance v1, Lcom/delta/attendancetracker/CourseAttendance$6;

    invoke-direct {v1, p0}, Lcom/delta/attendancetracker/CourseAttendance$6;-><init>(Lcom/delta/attendancetracker/CourseAttendance;)V

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setOnItemClickListener(Landroid/widget/AdapterView$OnItemClickListener;)V

    .line 457
    return-void
.end method

.method public onOptionsItemSelected(Landroid/view/MenuItem;)Z
    .locals 7
    .parameter "item"

    .prologue
    .line 470
    invoke-interface {p1}, Landroid/view/MenuItem;->getItemId()I

    move-result v5

    packed-switch v5, :pswitch_data_0

    .line 512
    invoke-super {p0, p1}, Landroid/support/v4/app/FragmentActivity;->onOptionsItemSelected(Landroid/view/MenuItem;)Z

    move-result v5

    :goto_0
    return v5

    .line 476
    :pswitch_0
    sget-object v5, Ljava/lang/System;->out:Ljava/io/PrintStream;

    const-string v6, "HIIIIIIIIIIIIIIIIIIIIIIIIIIi"

    invoke-virtual {v5, v6}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    .line 480
    :try_start_0
    new-instance v4, Lorg/json/JSONArray;

    invoke-direct {v4}, Lorg/json/JSONArray;-><init>()V

    .line 481
    .local v4, list:Lorg/json/JSONArray;
    new-instance v2, Lorg/json/JSONArray;

    const-string v5, "Courses"

    invoke-static {p0, v5}, Lcom/delta/attendancetracker/Prefs;->getMyStringPref(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    invoke-direct {v2, v5}, Lorg/json/JSONArray;-><init>(Ljava/lang/String;)V

    .line 482
    .local v2, jsonArray:Lorg/json/JSONArray;
    invoke-virtual {v2}, Lorg/json/JSONArray;->length()I

    move-result v3

    .line 483
    .local v3, len:I
    if-eqz v2, :cond_0

    .line 484
    const/4 v1, 0x0

    .local v1, i:I
    :goto_1
    if-lt v1, v3, :cond_1

    .line 494
    .end local v1           #i:I
    :cond_0
    const-string v5, "Courses"

    invoke-virtual {v4}, Lorg/json/JSONArray;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {p0, v5, v6}, Lcom/delta/attendancetracker/Prefs;->setMyStringPref(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    .line 495
    invoke-virtual {p0}, Lcom/delta/attendancetracker/CourseAttendance;->finish()V

    .line 502
    .end local v2           #jsonArray:Lorg/json/JSONArray;
    .end local v3           #len:I
    .end local v4           #list:Lorg/json/JSONArray;
    :goto_2
    const/4 v5, 0x1

    goto :goto_0

    .line 487
    .restart local v1       #i:I
    .restart local v2       #jsonArray:Lorg/json/JSONArray;
    .restart local v3       #len:I
    .restart local v4       #list:Lorg/json/JSONArray;
    :cond_1
    iget v5, p0, Lcom/delta/attendancetracker/CourseAttendance;->position:I

    if-eq v1, v5, :cond_2

    .line 489
    invoke-virtual {v2, v1}, Lorg/json/JSONArray;->get(I)Ljava/lang/Object;

    move-result-object v5

    invoke-virtual {v4, v5}, Lorg/json/JSONArray;->put(Ljava/lang/Object;)Lorg/json/JSONArray;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 484
    :cond_2
    add-int/lit8 v1, v1, 0x1

    goto :goto_1

    .line 497
    .end local v1           #i:I
    .end local v2           #jsonArray:Lorg/json/JSONArray;
    .end local v3           #len:I
    .end local v4           #list:Lorg/json/JSONArray;
    :catch_0
    move-exception v0

    .line 499
    .local v0, e:Lorg/json/JSONException;
    invoke-virtual {v0}, Lorg/json/JSONException;->printStackTrace()V

    goto :goto_2

    .line 470
    nop

    :pswitch_data_0
    .packed-switch 0x7f08001f
        :pswitch_0
    .end packed-switch
.end method

.method protected onPause()V
    .locals 0

    .prologue
    .line 379
    invoke-super {p0}, Landroid/support/v4/app/FragmentActivity;->onPause()V

    .line 381
    invoke-virtual {p0}, Lcom/delta/attendancetracker/CourseAttendance;->updateSharedPref()V

    .line 383
    return-void
.end method

.method protected onResume()V
    .locals 0

    .prologue
    .line 368
    invoke-super {p0}, Landroid/support/v4/app/FragmentActivity;->onResume()V

    .line 370
    invoke-virtual {p0}, Lcom/delta/attendancetracker/CourseAttendance;->update()V

    .line 372
    return-void
.end method

.method public showDatePickerDialog(Landroid/view/View;)V
    .locals 3
    .parameter "view"

    .prologue
    .line 285
    new-instance v0, Lcom/delta/attendancetracker/DatePickerFragment;

    invoke-direct {v0}, Lcom/delta/attendancetracker/DatePickerFragment;-><init>()V

    .line 286
    .local v0, newFragment:Landroid/support/v4/app/DialogFragment;
    invoke-virtual {p0}, Lcom/delta/attendancetracker/CourseAttendance;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v1

    const-string v2, "datePicker"

    invoke-virtual {v0, v1, v2}, Landroid/support/v4/app/DialogFragment;->show(Landroid/support/v4/app/FragmentManager;Ljava/lang/String;)V

    .line 287
    return-void
.end method

.method public update()V
    .locals 13

    .prologue
    const/high16 v12, 0x42c8

    .line 301
    sget-object v8, Ljava/lang/System;->out:Ljava/io/PrintStream;

    const-string v9, "In update"

    invoke-virtual {v8, v9}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    .line 303
    iget-object v8, p0, Lcom/delta/attendancetracker/CourseAttendance;->nClassesHeld:Landroid/widget/TextView;

    invoke-virtual {v8}, Landroid/widget/TextView;->getText()Ljava/lang/CharSequence;

    move-result-object v8

    invoke-interface {v8}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-static {v8}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v8

    int-to-float v1, v8

    .line 304
    .local v1, cHeld:F
    iget-object v8, p0, Lcom/delta/attendancetracker/CourseAttendance;->nClassesMissed:Landroid/widget/TextView;

    invoke-virtual {v8}, Landroid/widget/TextView;->getText()Ljava/lang/CharSequence;

    move-result-object v8

    invoke-interface {v8}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-static {v8}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v8

    int-to-float v2, v8

    .line 306
    .local v2, cMissed:F
    sget-object v8, Ljava/lang/System;->out:Ljava/io/PrintStream;

    new-instance v9, Ljava/lang/StringBuilder;

    invoke-static {v1}, Ljava/lang/String;->valueOf(F)Ljava/lang/String;

    move-result-object v10

    invoke-direct {v9, v10}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v10, " "

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9, v2}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    .line 308
    iget-object v8, p0, Lcom/delta/attendancetracker/CourseAttendance;->reqd:Landroid/widget/TextView;

    invoke-virtual {v8}, Landroid/widget/TextView;->getText()Ljava/lang/CharSequence;

    move-result-object v8

    invoke-interface {v8}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-static {v8}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v8

    int-to-float v6, v8

    .line 310
    .local v6, req:F
    sget-object v8, Ljava/lang/System;->out:Ljava/io/PrintStream;

    invoke-virtual {v8, v6}, Ljava/io/PrintStream;->println(F)V

    .line 312
    div-float v8, v2, v1

    mul-float/2addr v8, v12

    sub-float v0, v12, v8

    .line 314
    .local v0, attendancepercent:F
    sget-object v8, Ljava/lang/System;->out:Ljava/io/PrintStream;

    invoke-virtual {v8, v0}, Ljava/io/PrintStream;->println(F)V

    .line 316
    float-to-double v8, v1

    const-wide/16 v10, 0x0

    cmpl-double v8, v8, v10

    if-eqz v8, :cond_0

    iget-object v8, p0, Lcom/delta/attendancetracker/CourseAttendance;->attendance:Landroid/widget/TextView;

    invoke-static {v0}, Ljava/lang/Float;->toString(F)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 319
    :goto_0
    new-instance v7, Ljava/lang/String;

    invoke-direct {v7}, Ljava/lang/String;-><init>()V

    .line 322
    .local v7, total:Ljava/lang/String;
    :try_start_0
    iget-object v8, p0, Lcom/delta/attendancetracker/CourseAttendance;->extra:Lorg/json/JSONObject;

    const-string v9, "total"

    invoke-virtual {v8, v9}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v7

    .line 328
    :goto_1
    invoke-static {v7}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v8

    int-to-float v5, v8

    .line 330
    .local v5, maxClasses:F
    sget-object v8, Ljava/lang/System;->out:Ljava/io/PrintStream;

    new-instance v9, Ljava/lang/StringBuilder;

    const-string v10, "Total ::::::::: "

    invoke-direct {v9, v10}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v9, v5}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    .line 332
    sub-float v8, v5, v2

    div-float/2addr v8, v5

    mul-float v4, v8, v12

    .line 334
    .local v4, est:F
    iget-object v8, p0, Lcom/delta/attendancetracker/CourseAttendance;->estimated:Landroid/widget/TextView;

    invoke-static {v4}, Ljava/lang/Float;->toString(F)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 336
    return-void

    .line 317
    .end local v4           #est:F
    .end local v5           #maxClasses:F
    .end local v7           #total:Ljava/lang/String;
    :cond_0
    iget-object v8, p0, Lcom/delta/attendancetracker/CourseAttendance;->attendance:Landroid/widget/TextView;

    const-string v9, "0"

    invoke-virtual {v8, v9}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto :goto_0

    .line 323
    .restart local v7       #total:Ljava/lang/String;
    :catch_0
    move-exception v3

    .line 325
    .local v3, e:Lorg/json/JSONException;
    invoke-virtual {v3}, Lorg/json/JSONException;->printStackTrace()V

    goto :goto_1
.end method

.method public updateSharedPref()V
    .locals 12

    .prologue
    .line 387
    new-instance v0, Lorg/json/JSONObject;

    invoke-direct {v0}, Lorg/json/JSONObject;-><init>()V

    .line 389
    .local v0, course:Lorg/json/JSONObject;
    const-string v9, "Courses"

    invoke-static {p0, v9}, Lcom/delta/attendancetracker/Prefs;->getMyStringPref(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 393
    .local v1, courses:Ljava/lang/String;
    new-instance v2, Lorg/json/JSONArray;

    invoke-direct {v2}, Lorg/json/JSONArray;-><init>()V

    .line 394
    .local v2, courses_json:Lorg/json/JSONArray;
    new-instance v7, Lorg/json/JSONObject;

    invoke-direct {v7}, Lorg/json/JSONObject;-><init>()V

    .line 396
    .local v7, jo:Lorg/json/JSONObject;
    if-eqz v1, :cond_0

    .line 398
    :try_start_0
    new-instance v3, Lorg/json/JSONArray;

    invoke-direct {v3, v1}, Lorg/json/JSONArray;-><init>(Ljava/lang/String;)V
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 399
    .end local v2           #courses_json:Lorg/json/JSONArray;
    .local v3, courses_json:Lorg/json/JSONArray;
    const/4 v5, 0x0

    .local v5, i:I
    :goto_0
    :try_start_1
    invoke-virtual {v3}, Lorg/json/JSONArray;->length()I
    :try_end_1
    .catch Lorg/json/JSONException; {:try_start_1 .. :try_end_1} :catch_1

    move-result v9

    if-lt v5, v9, :cond_1

    move-object v2, v3

    .line 430
    .end local v3           #courses_json:Lorg/json/JSONArray;
    .end local v5           #i:I
    .restart local v2       #courses_json:Lorg/json/JSONArray;
    :cond_0
    :goto_1
    const-string v9, "Courses"

    invoke-virtual {v2}, Lorg/json/JSONArray;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-static {p0, v9, v10}, Lcom/delta/attendancetracker/Prefs;->setMyStringPref(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    .line 432
    sget-object v9, Ljava/lang/System;->out:Ljava/io/PrintStream;

    new-instance v10, Ljava/lang/StringBuilder;

    const-string v11, "Courses ::: "

    invoke-direct {v10, v11}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2}, Lorg/json/JSONArray;->toString()Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v9, v10}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    .line 434
    return-void

    .line 401
    .end local v2           #courses_json:Lorg/json/JSONArray;
    .restart local v3       #courses_json:Lorg/json/JSONArray;
    .restart local v5       #i:I
    :cond_1
    :try_start_2
    sget-object v9, Ljava/lang/System;->out:Ljava/io/PrintStream;

    invoke-virtual {v9, v5}, Ljava/io/PrintStream;->println(I)V

    .line 403
    invoke-virtual {v3, v5}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v9

    const-string v10, "name"

    invoke-virtual {v9, v10}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    iget-object v10, p0, Lcom/delta/attendancetracker/CourseAttendance;->courseName:Ljava/lang/String;

    invoke-virtual {v9, v10}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_3

    .line 405
    sget-object v9, Ljava/lang/System;->out:Ljava/io/PrintStream;

    const-string v10, "Satisfied"

    invoke-virtual {v9, v10}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    .line 407
    invoke-virtual {v3, v5}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v9

    const-string v10, "classesHeld"

    iget-object v11, p0, Lcom/delta/attendancetracker/CourseAttendance;->nClassesHeld:Landroid/widget/TextView;

    invoke-virtual {v11}, Landroid/widget/TextView;->getText()Ljava/lang/CharSequence;

    move-result-object v11

    invoke-interface {v11}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v9, v10, v11}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 408
    invoke-virtual {v3, v5}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v9

    const-string v10, "classesMissed"

    iget-object v11, p0, Lcom/delta/attendancetracker/CourseAttendance;->nClassesMissed:Landroid/widget/TextView;

    invoke-virtual {v11}, Landroid/widget/TextView;->getText()Ljava/lang/CharSequence;

    move-result-object v11

    invoke-interface {v11}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v9, v10, v11}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 410
    sget-object v9, Ljava/lang/System;->out:Ljava/io/PrintStream;

    new-instance v10, Ljava/lang/StringBuilder;

    const-string v11, "MissedList : : : "

    invoke-direct {v10, v11}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v11, p0, Lcom/delta/attendancetracker/CourseAttendance;->missedlist:Ljava/util/ArrayList;

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v9, v10}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    .line 412
    new-instance v8, Lorg/json/JSONArray;

    invoke-direct {v8}, Lorg/json/JSONArray;-><init>()V

    .line 413
    .local v8, newDatesMissed:Lorg/json/JSONArray;
    const/4 v6, 0x0

    .local v6, j:I
    :goto_2
    iget-object v9, p0, Lcom/delta/attendancetracker/CourseAttendance;->missedlist:Ljava/util/ArrayList;

    invoke-virtual {v9}, Ljava/util/ArrayList;->size()I

    move-result v9

    if-lt v6, v9, :cond_2

    .line 414
    invoke-virtual {v3, v5}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v9

    const-string v10, "datesMissed"

    invoke-virtual {v9, v10, v8}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    move-object v2, v3

    .line 417
    .end local v3           #courses_json:Lorg/json/JSONArray;
    .restart local v2       #courses_json:Lorg/json/JSONArray;
    goto/16 :goto_1

    .line 413
    .end local v2           #courses_json:Lorg/json/JSONArray;
    .restart local v3       #courses_json:Lorg/json/JSONArray;
    :cond_2
    iget-object v9, p0, Lcom/delta/attendancetracker/CourseAttendance;->missedlist:Ljava/util/ArrayList;

    invoke-virtual {v9, v6}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Ljava/lang/String;

    invoke-virtual {v9}, Ljava/lang/String;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Lorg/json/JSONArray;->put(Ljava/lang/Object;)Lorg/json/JSONArray;
    :try_end_2
    .catch Lorg/json/JSONException; {:try_start_2 .. :try_end_2} :catch_1

    add-int/lit8 v6, v6, 0x1

    goto :goto_2

    .line 399
    .end local v6           #j:I
    .end local v8           #newDatesMissed:Lorg/json/JSONArray;
    :cond_3
    add-int/lit8 v5, v5, 0x1

    goto/16 :goto_0

    .line 422
    .end local v3           #courses_json:Lorg/json/JSONArray;
    .end local v5           #i:I
    .restart local v2       #courses_json:Lorg/json/JSONArray;
    :catch_0
    move-exception v4

    .line 424
    .local v4, e:Lorg/json/JSONException;
    :goto_3
    invoke-virtual {v4}, Lorg/json/JSONException;->printStackTrace()V

    goto/16 :goto_1

    .line 422
    .end local v2           #courses_json:Lorg/json/JSONArray;
    .end local v4           #e:Lorg/json/JSONException;
    .restart local v3       #courses_json:Lorg/json/JSONArray;
    .restart local v5       #i:I
    :catch_1
    move-exception v4

    move-object v2, v3

    .end local v3           #courses_json:Lorg/json/JSONArray;
    .restart local v2       #courses_json:Lorg/json/JSONArray;
    goto :goto_3
.end method

.method public updatedate(Ljava/lang/String;I)V
    .locals 2
    .parameter "date"
    .parameter "position"

    .prologue
    .line 292
    iget-object v0, p0, Lcom/delta/attendancetracker/CourseAttendance;->missedlist:Ljava/util/ArrayList;

    invoke-virtual {v0, p2, p1}, Ljava/util/ArrayList;->set(ILjava/lang/Object;)Ljava/lang/Object;

    .line 295
    iget-object v0, p0, Lcom/delta/attendancetracker/CourseAttendance;->adapter:Lcom/delta/attendancetracker/CourseAttendance$StableArrayAdapter;

    invoke-virtual {v0}, Lcom/delta/attendancetracker/CourseAttendance$StableArrayAdapter;->notifyDataSetChanged()V

    .line 296
    iget-object v0, p0, Lcom/delta/attendancetracker/CourseAttendance;->classesmissed:Landroid/widget/ListView;

    iget-object v1, p0, Lcom/delta/attendancetracker/CourseAttendance;->adapter:Lcom/delta/attendancetracker/CourseAttendance$StableArrayAdapter;

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 297
    return-void
.end method
