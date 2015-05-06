.class Lcom/delta/attendancetracker/CourseAttendance$4;
.super Ljava/lang/Object;
.source "CourseAttendance.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/delta/attendancetracker/CourseAttendance;->onCreate(Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/delta/attendancetracker/CourseAttendance;


# direct methods
.method constructor <init>(Lcom/delta/attendancetracker/CourseAttendance;)V
    .locals 0
    .parameter

    .prologue
    .line 1
    iput-object p1, p0, Lcom/delta/attendancetracker/CourseAttendance$4;->this$0:Lcom/delta/attendancetracker/CourseAttendance;

    .line 184
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static synthetic access$0(Lcom/delta/attendancetracker/CourseAttendance$4;)Lcom/delta/attendancetracker/CourseAttendance;
    .locals 1
    .parameter

    .prologue
    .line 184
    iget-object v0, p0, Lcom/delta/attendancetracker/CourseAttendance$4;->this$0:Lcom/delta/attendancetracker/CourseAttendance;

    return-object v0
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 10
    .parameter "arg0"

    .prologue
    .line 190
    iget-object v4, p0, Lcom/delta/attendancetracker/CourseAttendance$4;->this$0:Lcom/delta/attendancetracker/CourseAttendance;

    iget-object v4, v4, Lcom/delta/attendancetracker/CourseAttendance;->nClassesMissed:Landroid/widget/TextView;

    invoke-virtual {v4}, Landroid/widget/TextView;->getText()Ljava/lang/CharSequence;

    move-result-object v4

    invoke-interface {v4}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v2

    .line 191
    .local v2, mPlus:I
    add-int/lit8 v2, v2, 0x1

    .line 193
    iget-object v4, p0, Lcom/delta/attendancetracker/CourseAttendance$4;->this$0:Lcom/delta/attendancetracker/CourseAttendance;

    iget-object v4, v4, Lcom/delta/attendancetracker/CourseAttendance;->nClassesHeld:Landroid/widget/TextView;

    invoke-virtual {v4}, Landroid/widget/TextView;->getText()Ljava/lang/CharSequence;

    move-result-object v4

    invoke-interface {v4}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v3

    .line 195
    .local v3, q:I
    if-gt v2, v3, :cond_0

    .line 197
    iget-object v4, p0, Lcom/delta/attendancetracker/CourseAttendance$4;->this$0:Lcom/delta/attendancetracker/CourseAttendance;

    iget-object v4, v4, Lcom/delta/attendancetracker/CourseAttendance;->nClassesMissed:Landroid/widget/TextView;

    invoke-static {v2}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 199
    invoke-static {}, Ljava/util/Calendar;->getInstance()Ljava/util/Calendar;

    move-result-object v0

    .line 200
    .local v0, c:Ljava/util/Calendar;
    iget-object v4, p0, Lcom/delta/attendancetracker/CourseAttendance$4;->this$0:Lcom/delta/attendancetracker/CourseAttendance;

    const/4 v5, 0x1

    invoke-virtual {v0, v5}, Ljava/util/Calendar;->get(I)I

    move-result v5

    iput v5, v4, Lcom/delta/attendancetracker/CourseAttendance;->yy:I

    .line 201
    iget-object v4, p0, Lcom/delta/attendancetracker/CourseAttendance$4;->this$0:Lcom/delta/attendancetracker/CourseAttendance;

    const/4 v5, 0x2

    invoke-virtual {v0, v5}, Ljava/util/Calendar;->get(I)I

    move-result v5

    iput v5, v4, Lcom/delta/attendancetracker/CourseAttendance;->mm:I

    .line 202
    iget-object v4, p0, Lcom/delta/attendancetracker/CourseAttendance$4;->this$0:Lcom/delta/attendancetracker/CourseAttendance;

    const/4 v5, 0x5

    invoke-virtual {v0, v5}, Ljava/util/Calendar;->get(I)I

    move-result v5

    iput v5, v4, Lcom/delta/attendancetracker/CourseAttendance;->dd:I

    .line 204
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v5, p0, Lcom/delta/attendancetracker/CourseAttendance$4;->this$0:Lcom/delta/attendancetracker/CourseAttendance;

    iget v5, v5, Lcom/delta/attendancetracker/CourseAttendance;->dd:I

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, " "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "/"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, " "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    iget-object v5, p0, Lcom/delta/attendancetracker/CourseAttendance$4;->this$0:Lcom/delta/attendancetracker/CourseAttendance;

    iget v5, v5, Lcom/delta/attendancetracker/CourseAttendance;->mm:I

    add-int/lit8 v5, v5, 0x1

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, " /"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, " "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    iget-object v5, p0, Lcom/delta/attendancetracker/CourseAttendance$4;->this$0:Lcom/delta/attendancetracker/CourseAttendance;

    iget v5, v5, Lcom/delta/attendancetracker/CourseAttendance;->yy:I

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 206
    .local v1, currentdate:Ljava/lang/StringBuilder;
    iget-object v4, p0, Lcom/delta/attendancetracker/CourseAttendance$4;->this$0:Lcom/delta/attendancetracker/CourseAttendance;

    iget-object v4, v4, Lcom/delta/attendancetracker/CourseAttendance;->missedlist:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 208
    iget-object v4, p0, Lcom/delta/attendancetracker/CourseAttendance$4;->this$0:Lcom/delta/attendancetracker/CourseAttendance;

    new-instance v5, Lcom/delta/attendancetracker/CourseAttendance$StableArrayAdapter;

    iget-object v6, p0, Lcom/delta/attendancetracker/CourseAttendance$4;->this$0:Lcom/delta/attendancetracker/CourseAttendance;

    iget-object v7, p0, Lcom/delta/attendancetracker/CourseAttendance$4;->this$0:Lcom/delta/attendancetracker/CourseAttendance;

    .line 209
    const v8, 0x1090003

    iget-object v9, p0, Lcom/delta/attendancetracker/CourseAttendance$4;->this$0:Lcom/delta/attendancetracker/CourseAttendance;

    iget-object v9, v9, Lcom/delta/attendancetracker/CourseAttendance;->missedlist:Ljava/util/ArrayList;

    invoke-direct {v5, v6, v7, v8, v9}, Lcom/delta/attendancetracker/CourseAttendance$StableArrayAdapter;-><init>(Lcom/delta/attendancetracker/CourseAttendance;Landroid/content/Context;ILjava/util/List;)V

    .line 208
    iput-object v5, v4, Lcom/delta/attendancetracker/CourseAttendance;->adapter:Lcom/delta/attendancetracker/CourseAttendance$StableArrayAdapter;

    .line 210
    iget-object v4, p0, Lcom/delta/attendancetracker/CourseAttendance$4;->this$0:Lcom/delta/attendancetracker/CourseAttendance;

    iget-object v4, v4, Lcom/delta/attendancetracker/CourseAttendance;->adapter:Lcom/delta/attendancetracker/CourseAttendance$StableArrayAdapter;

    invoke-virtual {v4}, Lcom/delta/attendancetracker/CourseAttendance$StableArrayAdapter;->notifyDataSetChanged()V

    .line 212
    iget-object v4, p0, Lcom/delta/attendancetracker/CourseAttendance$4;->this$0:Lcom/delta/attendancetracker/CourseAttendance;

    iget-object v4, v4, Lcom/delta/attendancetracker/CourseAttendance;->classesmissed:Landroid/widget/ListView;

    iget-object v5, p0, Lcom/delta/attendancetracker/CourseAttendance$4;->this$0:Lcom/delta/attendancetracker/CourseAttendance;

    iget-object v5, v5, Lcom/delta/attendancetracker/CourseAttendance;->adapter:Lcom/delta/attendancetracker/CourseAttendance$StableArrayAdapter;

    invoke-virtual {v4, v5}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 214
    iget-object v4, p0, Lcom/delta/attendancetracker/CourseAttendance$4;->this$0:Lcom/delta/attendancetracker/CourseAttendance;

    iget-object v4, v4, Lcom/delta/attendancetracker/CourseAttendance;->classesmissed:Landroid/widget/ListView;

    new-instance v5, Lcom/delta/attendancetracker/CourseAttendance$4$1;

    invoke-direct {v5, p0}, Lcom/delta/attendancetracker/CourseAttendance$4$1;-><init>(Lcom/delta/attendancetracker/CourseAttendance$4;)V

    invoke-virtual {v4, v5}, Landroid/widget/ListView;->setOnItemClickListener(Landroid/widget/AdapterView$OnItemClickListener;)V

    .line 228
    .end local v0           #c:Ljava/util/Calendar;
    .end local v1           #currentdate:Ljava/lang/StringBuilder;
    :cond_0
    iget-object v4, p0, Lcom/delta/attendancetracker/CourseAttendance$4;->this$0:Lcom/delta/attendancetracker/CourseAttendance;

    invoke-virtual {v4}, Lcom/delta/attendancetracker/CourseAttendance;->update()V

    .line 230
    return-void
.end method
