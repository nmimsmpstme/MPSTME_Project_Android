.class Lcom/delta/attendancetracker/CourseAttendance$StableArrayAdapter;
.super Landroid/widget/ArrayAdapter;
.source "CourseAttendance.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/delta/attendancetracker/CourseAttendance;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "StableArrayAdapter"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/widget/ArrayAdapter",
        "<",
        "Ljava/lang/String;",
        ">;"
    }
.end annotation


# instance fields
.field mIdMap:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation
.end field

.field final synthetic this$0:Lcom/delta/attendancetracker/CourseAttendance;


# direct methods
.method public constructor <init>(Lcom/delta/attendancetracker/CourseAttendance;Landroid/content/Context;ILjava/util/List;)V
    .locals 4
    .parameter
    .parameter "context"
    .parameter "textViewResourceId"
    .parameter
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "I",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 343
    .local p4, objects:Ljava/util/List;,"Ljava/util/List<Ljava/lang/String;>;"
    iput-object p1, p0, Lcom/delta/attendancetracker/CourseAttendance$StableArrayAdapter;->this$0:Lcom/delta/attendancetracker/CourseAttendance;

    .line 344
    invoke-direct {p0, p2, p3, p4}, Landroid/widget/ArrayAdapter;-><init>(Landroid/content/Context;ILjava/util/List;)V

    .line 340
    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    iput-object v1, p0, Lcom/delta/attendancetracker/CourseAttendance$StableArrayAdapter;->mIdMap:Ljava/util/HashMap;

    .line 345
    const/4 v0, 0x0

    .local v0, i:I
    :goto_0
    invoke-interface {p4}, Ljava/util/List;->size()I

    move-result v1

    if-lt v0, v1, :cond_0

    .line 348
    return-void

    .line 346
    :cond_0
    iget-object v2, p0, Lcom/delta/attendancetracker/CourseAttendance$StableArrayAdapter;->mIdMap:Ljava/util/HashMap;

    invoke-interface {p4, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {v2, v1, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 345
    add-int/lit8 v0, v0, 0x1

    goto :goto_0
.end method


# virtual methods
.method public getItemId(I)J
    .locals 3
    .parameter "position"

    .prologue
    .line 352
    invoke-virtual {p0, p1}, Lcom/delta/attendancetracker/CourseAttendance$StableArrayAdapter;->getItem(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 353
    .local v0, item:Ljava/lang/String;
    iget-object v1, p0, Lcom/delta/attendancetracker/CourseAttendance$StableArrayAdapter;->mIdMap:Ljava/util/HashMap;

    invoke-virtual {v1, v0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/Integer;

    invoke-virtual {v1}, Ljava/lang/Integer;->intValue()I

    move-result v1

    int-to-long v1, v1

    return-wide v1
.end method

.method public hasStableIds()Z
    .locals 1

    .prologue
    .line 358
    const/4 v0, 0x1

    return v0
.end method
