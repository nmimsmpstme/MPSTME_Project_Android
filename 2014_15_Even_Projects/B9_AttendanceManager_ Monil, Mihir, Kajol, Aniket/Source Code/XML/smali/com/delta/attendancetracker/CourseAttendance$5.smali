.class Lcom/delta/attendancetracker/CourseAttendance$5;
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
    iput-object p1, p0, Lcom/delta/attendancetracker/CourseAttendance$5;->this$0:Lcom/delta/attendancetracker/CourseAttendance;

    .line 233
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static synthetic access$0(Lcom/delta/attendancetracker/CourseAttendance$5;)Lcom/delta/attendancetracker/CourseAttendance;
    .locals 1
    .parameter

    .prologue
    .line 233
    iget-object v0, p0, Lcom/delta/attendancetracker/CourseAttendance$5;->this$0:Lcom/delta/attendancetracker/CourseAttendance;

    return-object v0
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 7
    .parameter "arg0"

    .prologue
    .line 239
    iget-object v1, p0, Lcom/delta/attendancetracker/CourseAttendance$5;->this$0:Lcom/delta/attendancetracker/CourseAttendance;

    iget-object v1, v1, Lcom/delta/attendancetracker/CourseAttendance;->nClassesMissed:Landroid/widget/TextView;

    invoke-virtual {v1}, Landroid/widget/TextView;->getText()Ljava/lang/CharSequence;

    move-result-object v1

    invoke-interface {v1}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v0

    .line 240
    .local v0, mMinus:I
    add-int/lit8 v0, v0, -0x1

    .line 242
    if-ltz v0, :cond_1

    .line 244
    iget-object v1, p0, Lcom/delta/attendancetracker/CourseAttendance$5;->this$0:Lcom/delta/attendancetracker/CourseAttendance;

    iget-object v1, v1, Lcom/delta/attendancetracker/CourseAttendance;->nClassesMissed:Landroid/widget/TextView;

    invoke-static {v0}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 246
    iget-object v1, p0, Lcom/delta/attendancetracker/CourseAttendance$5;->this$0:Lcom/delta/attendancetracker/CourseAttendance;

    iget-object v1, v1, Lcom/delta/attendancetracker/CourseAttendance;->missedlist:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v1

    if-eqz v1, :cond_0

    .line 248
    iget-object v1, p0, Lcom/delta/attendancetracker/CourseAttendance$5;->this$0:Lcom/delta/attendancetracker/CourseAttendance;

    iget-object v1, v1, Lcom/delta/attendancetracker/CourseAttendance;->missedlist:Ljava/util/ArrayList;

    iget-object v2, p0, Lcom/delta/attendancetracker/CourseAttendance$5;->this$0:Lcom/delta/attendancetracker/CourseAttendance;

    iget-object v2, v2, Lcom/delta/attendancetracker/CourseAttendance;->missedlist:Ljava/util/ArrayList;

    invoke-virtual {v2}, Ljava/util/ArrayList;->size()I

    move-result v2

    add-int/lit8 v2, v2, -0x1

    invoke-virtual {v1, v2}, Ljava/util/ArrayList;->remove(I)Ljava/lang/Object;

    .line 249
    iget-object v1, p0, Lcom/delta/attendancetracker/CourseAttendance$5;->this$0:Lcom/delta/attendancetracker/CourseAttendance;

    iget-object v1, v1, Lcom/delta/attendancetracker/CourseAttendance;->adapter:Lcom/delta/attendancetracker/CourseAttendance$StableArrayAdapter;

    invoke-virtual {v1}, Lcom/delta/attendancetracker/CourseAttendance$StableArrayAdapter;->notifyDataSetChanged()V

    .line 253
    :cond_0
    iget-object v1, p0, Lcom/delta/attendancetracker/CourseAttendance$5;->this$0:Lcom/delta/attendancetracker/CourseAttendance;

    new-instance v2, Lcom/delta/attendancetracker/CourseAttendance$StableArrayAdapter;

    iget-object v3, p0, Lcom/delta/attendancetracker/CourseAttendance$5;->this$0:Lcom/delta/attendancetracker/CourseAttendance;

    iget-object v4, p0, Lcom/delta/attendancetracker/CourseAttendance$5;->this$0:Lcom/delta/attendancetracker/CourseAttendance;

    .line 254
    const v5, 0x1090003

    iget-object v6, p0, Lcom/delta/attendancetracker/CourseAttendance$5;->this$0:Lcom/delta/attendancetracker/CourseAttendance;

    iget-object v6, v6, Lcom/delta/attendancetracker/CourseAttendance;->missedlist:Ljava/util/ArrayList;

    invoke-direct {v2, v3, v4, v5, v6}, Lcom/delta/attendancetracker/CourseAttendance$StableArrayAdapter;-><init>(Lcom/delta/attendancetracker/CourseAttendance;Landroid/content/Context;ILjava/util/List;)V

    .line 253
    iput-object v2, v1, Lcom/delta/attendancetracker/CourseAttendance;->adapter:Lcom/delta/attendancetracker/CourseAttendance$StableArrayAdapter;

    .line 256
    iget-object v1, p0, Lcom/delta/attendancetracker/CourseAttendance$5;->this$0:Lcom/delta/attendancetracker/CourseAttendance;

    iget-object v1, v1, Lcom/delta/attendancetracker/CourseAttendance;->classesmissed:Landroid/widget/ListView;

    iget-object v2, p0, Lcom/delta/attendancetracker/CourseAttendance$5;->this$0:Lcom/delta/attendancetracker/CourseAttendance;

    iget-object v2, v2, Lcom/delta/attendancetracker/CourseAttendance;->adapter:Lcom/delta/attendancetracker/CourseAttendance$StableArrayAdapter;

    invoke-virtual {v1, v2}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 258
    iget-object v1, p0, Lcom/delta/attendancetracker/CourseAttendance$5;->this$0:Lcom/delta/attendancetracker/CourseAttendance;

    iget-object v1, v1, Lcom/delta/attendancetracker/CourseAttendance;->classesmissed:Landroid/widget/ListView;

    new-instance v2, Lcom/delta/attendancetracker/CourseAttendance$5$1;

    invoke-direct {v2, p0}, Lcom/delta/attendancetracker/CourseAttendance$5$1;-><init>(Lcom/delta/attendancetracker/CourseAttendance$5;)V

    invoke-virtual {v1, v2}, Landroid/widget/ListView;->setOnItemClickListener(Landroid/widget/AdapterView$OnItemClickListener;)V

    .line 272
    :cond_1
    iget-object v1, p0, Lcom/delta/attendancetracker/CourseAttendance$5;->this$0:Lcom/delta/attendancetracker/CourseAttendance;

    invoke-virtual {v1}, Lcom/delta/attendancetracker/CourseAttendance;->update()V

    .line 274
    return-void
.end method
