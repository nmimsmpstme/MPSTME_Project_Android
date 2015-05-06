.class public Lcom/delta/attendancetracker/MainActivity;
.super Landroid/app/Activity;
.source "MainActivity.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/delta/attendancetracker/MainActivity$StableArrayAdapter;
    }
.end annotation


# instance fields
.field cList:Lorg/json/JSONArray;

.field lv:Landroid/widget/ListView;

.field tvempty:Landroid/widget/TextView;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 26
    invoke-direct {p0}, Landroid/app/Activity;-><init>()V

    .line 31
    new-instance v0, Lorg/json/JSONArray;

    invoke-direct {v0}, Lorg/json/JSONArray;-><init>()V

    iput-object v0, p0, Lcom/delta/attendancetracker/MainActivity;->cList:Lorg/json/JSONArray;

    .line 26
    return-void
.end method


# virtual methods
.method protected onCreate(Landroid/os/Bundle;)V
    .locals 2
    .parameter "savedInstanceState"

    .prologue
    .line 35
    invoke-super {p0, p1}, Landroid/app/Activity;->onCreate(Landroid/os/Bundle;)V

    .line 36
    const v0, 0x7f030003

    invoke-virtual {p0, v0}, Lcom/delta/attendancetracker/MainActivity;->setContentView(I)V

    .line 37
    const v0, 0x7f08001d

    invoke-virtual {p0, v0}, Lcom/delta/attendancetracker/MainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ListView;

    iput-object v0, p0, Lcom/delta/attendancetracker/MainActivity;->lv:Landroid/widget/ListView;

    .line 38
    const v0, 0x1020004

    invoke-virtual {p0, v0}, Lcom/delta/attendancetracker/MainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/delta/attendancetracker/MainActivity;->tvempty:Landroid/widget/TextView;

    .line 39
    iget-object v0, p0, Lcom/delta/attendancetracker/MainActivity;->lv:Landroid/widget/ListView;

    iget-object v1, p0, Lcom/delta/attendancetracker/MainActivity;->tvempty:Landroid/widget/TextView;

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setEmptyView(Landroid/view/View;)V

    .line 40
    const-string v0, "Long press a course to edit"

    const/4 v1, 0x0

    invoke-static {p0, v0, v1}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/Toast;->show()V

    .line 42
    return-void
.end method

.method public onCreateOptionsMenu(Landroid/view/Menu;)Z
    .locals 2
    .parameter "menu"

    .prologue
    .line 187
    invoke-virtual {p0}, Lcom/delta/attendancetracker/MainActivity;->getMenuInflater()Landroid/view/MenuInflater;

    move-result-object v0

    const v1, 0x7f070004

    invoke-virtual {v0, v1, p1}, Landroid/view/MenuInflater;->inflate(ILandroid/view/Menu;)V

    .line 188
    const/4 v0, 0x1

    return v0
.end method

.method public onOptionsItemSelected(Landroid/view/MenuItem;)Z
    .locals 2
    .parameter "item"

    .prologue
    .line 163
    invoke-interface {p1}, Landroid/view/MenuItem;->getItemId()I

    move-result v1

    packed-switch v1, :pswitch_data_0

    .line 180
    invoke-super {p0, p1}, Landroid/app/Activity;->onOptionsItemSelected(Landroid/view/MenuItem;)Z

    move-result v1

    :goto_0
    return v1

    .line 167
    :pswitch_0
    new-instance v0, Landroid/content/Intent;

    const-class v1, Lcom/delta/attendancetracker/AddCourse;

    invoke-direct {v0, p0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 168
    .local v0, addCourse:Landroid/content/Intent;
    invoke-virtual {p0, v0}, Lcom/delta/attendancetracker/MainActivity;->startActivity(Landroid/content/Intent;)V

    .line 170
    const/4 v1, 0x1

    goto :goto_0

    .line 163
    :pswitch_data_0
    .packed-switch 0x7f080020
        :pswitch_0
    .end packed-switch
.end method

.method protected onResume()V
    .locals 9

    .prologue
    .line 74
    invoke-super {p0}, Landroid/app/Activity;->onResume()V

    .line 76
    const-string v7, "Courses"

    invoke-static {p0, v7}, Lcom/delta/attendancetracker/Prefs;->getMyStringPref(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 81
    .local v1, courseList:Ljava/lang/String;
    :try_start_0
    new-instance v7, Lorg/json/JSONArray;

    invoke-direct {v7, v1}, Lorg/json/JSONArray;-><init>(Ljava/lang/String;)V

    iput-object v7, p0, Lcom/delta/attendancetracker/MainActivity;->cList:Lorg/json/JSONArray;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 87
    :goto_0
    iget-object v7, p0, Lcom/delta/attendancetracker/MainActivity;->cList:Lorg/json/JSONArray;

    invoke-virtual {v7}, Lorg/json/JSONArray;->length()I

    move-result v6

    .line 89
    .local v6, noOfCourses:I
    new-array v2, v6, [Ljava/lang/String;

    .line 91
    .local v2, courses:[Ljava/lang/String;
    const/4 v4, 0x0

    .local v4, i:I
    :goto_1
    if-lt v4, v6, :cond_0

    .line 99
    new-instance v5, Ljava/util/ArrayList;

    invoke-direct {v5}, Ljava/util/ArrayList;-><init>()V

    .line 100
    .local v5, list:Ljava/util/ArrayList;,"Ljava/util/ArrayList<Ljava/lang/String;>;"
    const/4 v4, 0x0

    :goto_2
    array-length v7, v2

    if-lt v4, v7, :cond_1

    .line 103
    new-instance v0, Lcom/delta/attendancetracker/MainActivity$StableArrayAdapter;

    .line 104
    const v7, 0x1090003

    .line 103
    invoke-direct {v0, p0, p0, v7, v5}, Lcom/delta/attendancetracker/MainActivity$StableArrayAdapter;-><init>(Lcom/delta/attendancetracker/MainActivity;Landroid/content/Context;ILjava/util/List;)V

    .line 105
    .local v0, adapter:Lcom/delta/attendancetracker/MainActivity$StableArrayAdapter;
    iget-object v7, p0, Lcom/delta/attendancetracker/MainActivity;->lv:Landroid/widget/ListView;

    invoke-virtual {v7, v0}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 108
    iget-object v7, p0, Lcom/delta/attendancetracker/MainActivity;->lv:Landroid/widget/ListView;

    new-instance v8, Lcom/delta/attendancetracker/MainActivity$1;

    invoke-direct {v8, p0}, Lcom/delta/attendancetracker/MainActivity$1;-><init>(Lcom/delta/attendancetracker/MainActivity;)V

    invoke-virtual {v7, v8}, Landroid/widget/ListView;->setOnItemClickListener(Landroid/widget/AdapterView$OnItemClickListener;)V

    .line 134
    iget-object v7, p0, Lcom/delta/attendancetracker/MainActivity;->lv:Landroid/widget/ListView;

    new-instance v8, Lcom/delta/attendancetracker/MainActivity$2;

    invoke-direct {v8, p0}, Lcom/delta/attendancetracker/MainActivity$2;-><init>(Lcom/delta/attendancetracker/MainActivity;)V

    invoke-virtual {v7, v8}, Landroid/widget/ListView;->setOnItemLongClickListener(Landroid/widget/AdapterView$OnItemLongClickListener;)V

    .line 155
    return-void

    .line 82
    .end local v0           #adapter:Lcom/delta/attendancetracker/MainActivity$StableArrayAdapter;
    .end local v2           #courses:[Ljava/lang/String;
    .end local v4           #i:I
    .end local v5           #list:Ljava/util/ArrayList;,"Ljava/util/ArrayList<Ljava/lang/String;>;"
    .end local v6           #noOfCourses:I
    :catch_0
    move-exception v3

    .line 84
    .local v3, e:Lorg/json/JSONException;
    invoke-virtual {v3}, Lorg/json/JSONException;->printStackTrace()V

    goto :goto_0

    .line 93
    .end local v3           #e:Lorg/json/JSONException;
    .restart local v2       #courses:[Ljava/lang/String;
    .restart local v4       #i:I
    .restart local v6       #noOfCourses:I
    :cond_0
    :try_start_1
    iget-object v7, p0, Lcom/delta/attendancetracker/MainActivity;->cList:Lorg/json/JSONArray;

    invoke-virtual {v7, v4}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v7

    const-string v8, "name"

    invoke-virtual {v7, v8}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    aput-object v7, v2, v4
    :try_end_1
    .catch Lorg/json/JSONException; {:try_start_1 .. :try_end_1} :catch_1

    .line 91
    :goto_3
    add-int/lit8 v4, v4, 0x1

    goto :goto_1

    .line 94
    :catch_1
    move-exception v3

    .line 96
    .restart local v3       #e:Lorg/json/JSONException;
    invoke-virtual {v3}, Lorg/json/JSONException;->printStackTrace()V

    goto :goto_3

    .line 101
    .end local v3           #e:Lorg/json/JSONException;
    .restart local v5       #list:Ljava/util/ArrayList;,"Ljava/util/ArrayList<Ljava/lang/String;>;"
    :cond_1
    aget-object v7, v2, v4

    invoke-virtual {v5, v7}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 100
    add-int/lit8 v4, v4, 0x1

    goto :goto_2
.end method
