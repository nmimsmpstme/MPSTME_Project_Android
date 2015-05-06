.class Lcom/delta/attendancetracker/AddCourse$1;
.super Ljava/lang/Object;
.source "AddCourse.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/delta/attendancetracker/AddCourse;->onCreate(Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/delta/attendancetracker/AddCourse;


# direct methods
.method constructor <init>(Lcom/delta/attendancetracker/AddCourse;)V
    .locals 0
    .parameter

    .prologue
    .line 1
    iput-object p1, p0, Lcom/delta/attendancetracker/AddCourse$1;->this$0:Lcom/delta/attendancetracker/AddCourse;

    .line 37
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 8
    .parameter "arg0"

    .prologue
    const/4 v7, 0x0

    .line 44
    iget-object v0, p0, Lcom/delta/attendancetracker/AddCourse$1;->this$0:Lcom/delta/attendancetracker/AddCourse;

    iget-object v0, v0, Lcom/delta/attendancetracker/AddCourse;->courseName:Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v0

    invoke-interface {v0}, Landroid/text/Editable;->toString()Ljava/lang/String;

    move-result-object v1

    .line 45
    .local v1, name:Ljava/lang/String;
    iget-object v0, p0, Lcom/delta/attendancetracker/AddCourse$1;->this$0:Lcom/delta/attendancetracker/AddCourse;

    iget-object v0, v0, Lcom/delta/attendancetracker/AddCourse;->courseCode:Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v0

    invoke-interface {v0}, Landroid/text/Editable;->toString()Ljava/lang/String;

    move-result-object v2

    .line 46
    .local v2, id:Ljava/lang/String;
    iget-object v0, p0, Lcom/delta/attendancetracker/AddCourse$1;->this$0:Lcom/delta/attendancetracker/AddCourse;

    iget-object v0, v0, Lcom/delta/attendancetracker/AddCourse;->totalClasses:Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v0

    invoke-interface {v0}, Landroid/text/Editable;->toString()Ljava/lang/String;

    move-result-object v3

    .line 47
    .local v3, total:Ljava/lang/String;
    iget-object v0, p0, Lcom/delta/attendancetracker/AddCourse$1;->this$0:Lcom/delta/attendancetracker/AddCourse;

    iget-object v0, v0, Lcom/delta/attendancetracker/AddCourse;->percentRequired:Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v0

    invoke-interface {v0}, Landroid/text/Editable;->toString()Ljava/lang/String;

    move-result-object v4

    .line 49
    .local v4, required:Ljava/lang/String;
    iget-object v0, p0, Lcom/delta/attendancetracker/AddCourse$1;->this$0:Lcom/delta/attendancetracker/AddCourse;

    iget-object v0, v0, Lcom/delta/attendancetracker/AddCourse;->radioButtonGroup:Landroid/widget/RadioGroup;

    invoke-virtual {v0}, Landroid/widget/RadioGroup;->getCheckedRadioButtonId()I

    move-result v5

    .line 51
    .local v5, radioButtonID:I
    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v0

    if-eqz v0, :cond_0

    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v0

    if-eqz v0, :cond_0

    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v0

    if-eqz v0, :cond_0

    invoke-virtual {v4}, Ljava/lang/String;->length()I

    move-result v0

    if-nez v0, :cond_1

    .line 53
    :cond_0
    iget-object v0, p0, Lcom/delta/attendancetracker/AddCourse$1;->this$0:Lcom/delta/attendancetracker/AddCourse;

    const-string v6, "Please fill all fields!"

    invoke-static {v0, v6, v7}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/Toast;->show()V

    .line 62
    :goto_0
    return-void

    .line 55
    :cond_1
    invoke-static {v4}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v0

    const/16 v6, 0x64

    if-le v0, v6, :cond_2

    .line 57
    iget-object v0, p0, Lcom/delta/attendancetracker/AddCourse$1;->this$0:Lcom/delta/attendancetracker/AddCourse;

    const-string v6, "Required % cannot be greater than 100!"

    invoke-static {v0, v6, v7}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/Toast;->show()V

    goto :goto_0

    .line 60
    :cond_2
    iget-object v0, p0, Lcom/delta/attendancetracker/AddCourse$1;->this$0:Lcom/delta/attendancetracker/AddCourse;

    invoke-virtual/range {v0 .. v5}, Lcom/delta/attendancetracker/AddCourse;->storeCourse(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V

    goto :goto_0
.end method
